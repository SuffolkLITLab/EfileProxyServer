package edu.suffolk.litlab.efsp.model;

import edu.suffolk.litlab.efsp.tyler.ecfcodes.DocumentTypeTableRow;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.FilingComponent;
import java.util.Optional;

/** An individual PDF, all a part of the same "document". The equivalent of an ALDocument. */
public record FilingAttachment(
    FilingComponent filingComponentCode,
    /** The description of this document. Goes into BinaryDescriptionText for Tyler. */
    String documentDescription,
    String fileName,
    byte[] fileContents,
    // This is, "determined via configuration within the EFM for each EFSP"?
    // So, we can just say yes?
    // Provides Document Type code / BinaryFormatStandardName
    Optional<DocumentTypeTableRow> documentTypeFormatStandardName,
    // If present, we've pre-counted the pages, if not, will have to count them later.
    Optional<Integer> pageCount) {}
