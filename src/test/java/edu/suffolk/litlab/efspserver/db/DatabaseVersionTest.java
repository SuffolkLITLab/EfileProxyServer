package edu.suffolk.litlab.efspserver.db;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class DatabaseVersionTest {
  private final static Logger log = 
      LoggerFactory.getLogger(DatabaseVersionTest.class); 

  @Container
  public PostgreSQLContainer<?> userDb =
      new PostgreSQLContainer<>(DockerImageName.parse("postgres:14"));

  @Container
  public PostgreSQLContainer<?> codeDb = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14"));

  private static final String v0AtRestInsert = """
           INSERT INTO at_rest_keys (
               "server_id", "server_name", "api_key", "tyler_enabled",
               "jeffnet_enabled", "created"
           ) VALUES (
               ?, ?, ?, ?,
               ?, ?)"""; 
  
  private DatabaseVersion dv;
  private Connection userConn;
  private Connection codeConn;
  private static final String apiKey = "p9AoR183QwMun7bvCmYkf";
  
  @BeforeEach
  public void setUp() throws SQLException, FileNotFoundException, IOException, URISyntaxException, ArchiveException {
    unTarGz("/tyler_efm_codes_v0_1_truncated.tar.gz");
    userDb.addFileSystemBind(this.getClass().getResource("/user_transactions_v0.sql").getPath(), "/docker-entrypoint-initdb.d/user_transactions.sql", BindMode.READ_WRITE);
    codeDb.addFileSystemBind("tyler_efm_codes_v0_1_truncated.sql", "/docker-entrypoint-initdb.d/tyler_efm_codes.sql", BindMode.READ_WRITE);
    userDb.start();
    codeDb.start();
    userConn = DatabaseCreator.makeSingleConnection(
        userDb.getDatabaseName(), userDb.getJdbcUrl(), 
        userDb.getUsername(), userDb.getPassword());
    codeConn = DatabaseCreator.makeSingleConnection(
        codeDb.getDatabaseName(), codeDb.getJdbcUrl(), 
        codeDb.getUsername(), userDb.getPassword());
    // st.executeUpdate(v0AtRestCreate);
    PreparedStatement pst = userConn.prepareStatement(v0AtRestInsert);
    pst.setObject(1, UUID.randomUUID());
    pst.setString(2, "MyServerName");
    pst.setString(3, apiKey);
    pst.setBoolean(4, true);
    pst.setBoolean(5, true);
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    pst.setTimestamp(6, ts);
    dv = new DatabaseVersion(codeConn, userConn);
  }
  
  @AfterEach
  public void cleanUp() {
    codeDb.close();
    userDb.close();
  }
  
  @Test
  public void testFullUpdate() throws SQLException, NoSuchAlgorithmException {
    dv.createTablesIfAbsent(false);
    dv.createTablesIfAbsent(false);
    assertEquals(0, dv.getSchemaVersion());
    dv.updateToLatest();
    assertEquals(DatabaseVersion.CURRENT_VERSION, dv.getSchemaVersion());
    String selectApiKey = "SELECT api_key FROM at_rest_keys WHERE server_name='MyServerName'";
    Statement st = userConn.createStatement();
    ResultSet rs = st.executeQuery(selectApiKey);

    LoginDatabase ld = new LoginDatabase(userConn);
    String manualHash = ld.makeHash(apiKey);
    
    while (rs.next()) {
      assertEquals(rs.getString(1), manualHash);
    }
    
    Statement codeSt = codeConn.createStatement();
    rs = codeSt.executeQuery("SELECT DISTINCT domain from location");

    while (rs.next()) {
      assertEquals(rs.getString(1), "illinois-stage");
    }
  }
  
  private List<File> unTarGz(String resourcePath) throws FileNotFoundException, IOException, ArchiveException, URISyntaxException {
    File output = unGzip(new File(this.getClass().getResource(resourcePath).toURI()), new File(".")); 
    return unTar(output, new File(".")); 
  }
  
  /** Untar an input file into an output file.
   * https://stackoverflow.com/questions/315618/how-do-i-extract-a-tar-file-in-java
   * 
   * The output file is created in the output folder, having the same name
   * as the input file, minus the '.tar' extension. 
   * 
   * @param inputFile     the input .tar file
   * @param outputDir     the output directory file. 
   * @throws IOException 
   * @throws FileNotFoundException
   *  
   * @return  The {@link List} of {@link File}s with the untared content.
   * @throws ArchiveException 
   */
  private static List<File> unTar(final File inputFile, final File outputDir) throws FileNotFoundException, IOException, ArchiveException {
      log.info(String.format("Untaring %s to dir %s.", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

      final List<File> untaredFiles = new LinkedList<File>();
      final InputStream is = new FileInputStream(inputFile); 
      final TarArchiveInputStream debInputStream = (TarArchiveInputStream) new ArchiveStreamFactory().createArchiveInputStream("tar", is);
      TarArchiveEntry entry = null; 
      while ((entry = (TarArchiveEntry)debInputStream.getNextEntry()) != null) {
          final File outputFile = new File(outputDir, entry.getName());
          if (entry.isDirectory()) {
              log.info(String.format("Attempting to write output directory %s.", outputFile.getAbsolutePath()));
              if (!outputFile.exists()) {
                  log.info(String.format("Attempting to create output directory %s.", outputFile.getAbsolutePath()));
                  if (!outputFile.mkdirs()) {
                      throw new IllegalStateException(String.format("Couldn't create directory %s.", outputFile.getAbsolutePath()));
                  }
              }
          } else {
              log.info(String.format("Creating output file %s.", outputFile.getAbsolutePath()));
              final OutputStream outputFileStream = new FileOutputStream(outputFile); 
              IOUtils.copy(debInputStream, outputFileStream);
              outputFileStream.close();
          }
          untaredFiles.add(outputFile);
      }
      debInputStream.close(); 

      return untaredFiles;
  }

  /**
   * Ungzip an input file into an output file.
   * <p>
   * The output file is created in the output folder, having the same name
   * as the input file, minus the '.gz' extension. 
   * 
   * @param inputFile     the input .gz file
   * @param outputDir     the output directory file. 
   * @throws IOException 
   * @throws FileNotFoundException
   *  
   * @return  The {@File} with the ungzipped content.
   */
  private static File unGzip(final File inputFile, final File outputDir) throws FileNotFoundException, IOException {
      log.info(String.format("Ungzipping %s to dir %s", inputFile.getAbsolutePath(), outputDir.getAbsolutePath()));

      final File outputFile = new File(outputDir, inputFile.getName().substring(0, inputFile.getName().length() - 3));

      final GZIPInputStream in = new GZIPInputStream(new FileInputStream(inputFile));
      final FileOutputStream out = new FileOutputStream(outputFile);

      IOUtils.copy(in, out);

      in.close();
      out.close();

      return outputFile;
  }
}
