This folder contains the WSDL files for the ECF Web Services SIP.

Note that there are multiple files with a .WSDL extension. Some are implementation specific, some are only to define the service.

ECF-4.0-WebServicesProfile-Definitions-v2.1.wsdl
* This is the current definition as published by the OASIS ECF TC.
* This WSDL uses a Document/Literal message format, which incidentally conflicts with the specification's section 2.5 which states:
  "Each message transmission MUST identify the operation being invoked within the SOAP Body only; 
   the (qualified) operation name MUST be the qualified name of the first child element of the SOAP body 
   element, as called for in section 7.1 of the [SOAP 1.1] specification"
   Document/Literal format does not include an operation name in the body. 
* This is a deficiency that is already recognized by the ECF Technical Committee and a remedy is currently in process by the TC

ECF-4.0-WebServicesProfile-Definitions-v2.1-DOC-LIT-WRAP.wsdl
* This is a modified version of the published WSDL, which is currently under review by the ECF TC for consideration as an update
  to the existing 4.0 WS-SIP, and as the baseline for ECF 5.0
* This WSDL follows a Document/Literal/Wrapped style, which satisfies section 2.5 of the Web Services SIP specification.
