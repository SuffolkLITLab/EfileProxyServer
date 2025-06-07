package edu.suffolk.litlab.efsp.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.encoder.Encoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/** A special logging class that we use to write server specific events to specific files. */
public class ServerSpecificAppender extends AppenderBase<ILoggingEvent> {

  Encoder<ILoggingEvent> encoder;

  // TODO(brycew): does this need a few more locks for better performance?
  protected final ReentrantLock lock = new ReentrantLock(false);

  Map<String, OutputStream> serverStreams = new HashMap<>();

  boolean immediateFlush = true;

  @Override
  public void start() {
    if (this.encoder == null) {
      addError("No encoder set for the appender named [" + name + "].");
      return;
    }

    super.start();
  }

  public void append(ILoggingEvent event) {
    // Get the MDC from the event to determine which server this came from
    String serverId = event.getMDCPropertyMap().getOrDefault("serverId", "no-server");
    lock.lock();
    try {
      if (!serverStreams.containsKey(serverId)) {
        OutputStream newStream = new FileOutputStream(new File(serverId + ".log"));
        serverStreams.put(serverId, newStream);
      }
      var stream = serverStreams.get(serverId);
      byte[] byteArray = this.encoder.encode(event);
      stream.write(byteArray);
      if (immediateFlush) {
        stream.flush();
      }
    } catch (FileNotFoundException ex) {
      addError("Cannot find " + serverId + ".log");
    } catch (IOException ex) {
      addError("Got IO Exception writing to " + serverId + ".log");
    } finally {
      lock.unlock();
    }
    if (event.getLevel().equals(Level.ERROR)) {
      Monitor.sendErrorNotification(event.getFormattedMessage());
    }
  }

  public Encoder<ILoggingEvent> getEncoder() {
    return encoder;
  }

  public void setEncoder(Encoder<ILoggingEvent> encoder) {
    this.encoder = encoder;
  }

  public boolean isImmediateFlush() {
    return immediateFlush;
  }

  public void setImmediateFlush(boolean immediateFlush) {
    this.immediateFlush = immediateFlush;
  }
}
