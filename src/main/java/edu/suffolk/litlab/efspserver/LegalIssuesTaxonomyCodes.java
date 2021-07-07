package edu.suffolk.litlab.efspserver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegalIssuesTaxonomyCodes {
  private static Logger log = LoggerFactory.getLogger(LegalIssuesTaxonomyCodes.class); 

  /** Reads a special version of the csv at originally from https://taxonomy.legal/download. 
   * A column is added before "Taxonomies" that maps top level codes to ECF case types:
   * https://docs.oasis-open.org/legalxml-courtfiling/specs/ecf/v4.01/ecf-v4.01-spec/errata02/os/ecf-v4.01-spec-errata02-os-complete.html#_Toc425241622
   */
  public LegalIssuesTaxonomyCodes(InputStream csvFile) throws IOException, CsvValidationException {
    taxonomyGraph = new HashMap<String, InternalNode>();
    Reader r = new InputStreamReader(csvFile); 
    CSVReader reader = new CSVReader(r);
    reader.skip(1); // The first line is the headers
    String[] row = reader.readNext();
    while (row != null) {
      if (row.length < 5) {
        reader.close();
        throw new CsvValidationException();
      }
      Set<String> parents = new HashSet<String>(Arrays.asList(row[3].split(",")));
      InternalNode node = new InternalNode(row[0], row[1], row[2], parents, 
          (row[4].isBlank()) ? Optional.empty() : Optional.of(row[4]));
      taxonomyGraph.put(row[0], node);
      row = reader.readNext();
    }
    reader.close();
    
    this.calculateChildren();
  }

  public boolean contains(String code) {
    return taxonomyGraph.containsKey(code);
  }
  
  /** Get all possible ECF case types for the given colleciton of LIST codes. Can be multiple. */
  public Set<String> allEcfCaseTypes(Collection<String> categories) {
    Set<String> ecfCases = new HashSet<String>();
    for (String category : categories) {
      getEcfCases(category, ecfCases);
    }
    return ecfCases;
  }
  
  
  Map<String, InternalNode> taxonomyGraph;
  
  private void calculateChildren() {
    for (Map.Entry<String, InternalNode> entry : taxonomyGraph.entrySet()) {
      for (Map.Entry<String, InternalNode> possibleParent : taxonomyGraph.entrySet()) {
        if (possibleParent.getKey().equals(entry.getKey())) {
          continue;
        }
        if (entry.getValue().parentIs(possibleParent.getKey())) {
          possibleParent.getValue().addChild(entry.getKey());
        }
      }
    }
  }
  
  private void getEcfCases(String category, Set<String> runningCases) {
    log.info("Trying key: " + category);
    if (!taxonomyGraph.containsKey(category)) {
      return; 
    }

    InternalNode node = taxonomyGraph.get(category);
    log.info("At node: " + node.title);
    if (node.caseCategory.isPresent()) {
      log.info("Adding " + node.caseCategory.get() + " to running");
      runningCases.add(node.caseCategory.get());
      // TODO(brycew): should we exit early and not add the ECF case types from parent?
      // Example: Money is usually Civil, but the Bankruptcy sub cat is just Bankruptcy
      return;
    }
    for (String parent : node.parents) {
      getEcfCases(parent, runningCases);
    }
    return; 
  }

  
  /** A very lazy list-based adjacency directed graph implementation. 
   * Each node has parents, and children. All nodes are contained in a map
   * in the parent class.
   */
  class InternalNode {
    String code;
    String title;
    String definition;
    Optional<String> caseCategory;
    
    Set<String> parents;
    Set<String> children;
    
    public InternalNode(String code, String title, String definition, 
        Set<String> parents, Optional<String> caseType) {
      this.code = code;
      this.title = title;
      this.definition = definition;
      this.parents = parents;
      this.children = new HashSet<String>();
      this.caseCategory = caseType;
    }
    
    public boolean parentIs(String parent) {
      return parents.contains(parent);
    }
    
    public boolean childIs(String child) {
      return children.contains(child);
    }
    
    public void addChild(String child) {
      this.children.add(child);
    }
  }
}