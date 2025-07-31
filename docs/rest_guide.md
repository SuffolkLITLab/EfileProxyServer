# Using the REST interface: a guide

While most of Suffolk's work is on [docassemble](docassemble.org) and integrates with this server using [docassemble-EFSPIntegration](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration), it is possible to directly call this server using the REST endpoints. This high-level guide lays out the best order to make those calls, and where to look for more details on what data to send.

Note that all of these endpoints start with `/jurisdictions/{jurisdiction_id}`, in order to handle the different jurisdictions like Massachusetts or Illinois. These will be replaced with `...` to focus on the unique parts of the endpoints.

## Account creation and login

TODO

## Case search and parsing

TODO

## Query court codes

TODO

## Calculate payment, check filing, and submitting

These three endpoints each deal with the same large request payload: the entire filing.

* [.../filingreview/courts/{court_id}/filing/fees](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/calculateFilingFees) returns the fees breakdown for this filing, such as the fees incurred with certain optional services.
* [.../filingreview/courts/{court_id}/filing/check](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/checkFilingForReview) checks that this filing is correct, without submitting it if it is.
* [.../filingreview/courts/{court_id}/filings](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/submitFilingForReview) submits the filing.

### The filing payload

```json
{
    ///////////////
    ///// case info
    "efile_case_category": "123", // the Case Category code
    "efile_case_type": "234", // the Case type code
    "efile_case_subtype": "567", // the case subtype code
    // the case UUID from /cases/court/.../cases, if filing into a previous case
    "previous_case_id": "EFA3E3DE-EFBD-4211-B7E6-E53588CB3D11", 
    "docket_number": "25HR0005",

    //////////////
    // handling people
    "users": [
        {
            // Phones need to match a regex from Tyler, found in the "PartyPhone" datafield. We automatically strip dashes.
            "mobile_number": "617-123-4567", 
            "phone_number": "617-456-7890",
            "address": {
                "address": "123 Main St",
                "unit": "Apt 2",
                "city": "Boston",
                "state": "MA",
                "zip": "02127",
                "country": "US" // needs to be a 2 letter code (see CountryCodeSimpleType), defaults to US
            },
            "email": "cool_dude1@example.com",
            "party_type": "567", // the party type codes
            "prefered_language": "EN", // optional, and in Illinois, not used
            "gender": "male", // only needed if the PartyGender datafield is visible / required, no 'X' unfortunately, only M, F, and U for unknown.
            "date_of_birth": "YYYY-MM-DD",
            "is_form_filler": true,
            "name": {
                "first": "Jordan",
                "middle": "Haworth",
                "last": "Peele",
                "suffix": "" // For like Jr., etc.
            },
            "tyler_id": "12345678-1234-1234-1234-12345678abdc", // the UUID found from an existing case, if there is one. 
            "is_new": false // true if this is a new participant, or if it's a new filing.
        }
    ],
    "other_parties": [
        // Same as users, usually only needed if making a new case
        ...
    ],
    "user_preferred_language": "EN", // an alternate to "prefered_language" in users[0] 
    "user_started_case": true,
    "user_role": "plaintiff", // only used if "user_started_case" isn't present.
    "attorney_ids": ["abc123", "def456"], // should be the UUIDs from `.../firmattorneyservice/attorneys`
    // same here, maps IDs from attorney_ids to the parties they represent.
    "party_to_attorneys": { "users[0]": [], "users[1]": ["abc123"]}, 
    "service_contacts": [
        {
            "party_association": "users[0]",
            "contact_id": "12345678-1234-1234-1234-12345678abcd", // from .../firmattorneyservice/service-contacts
            "service_type": "678", // must be a service type code
        } 
    ],

    /////////////////////////////
    /////// Appeals: only necessary if there's a parent case
    "lower_court_case": {
        "judge": {
            "first": "Bob",
            "last": "Brown"
        }, // or just their full name in a string
        "title": "Willey in re",
        "docket_number": "24HR0006", // depends on jurisdiction
    },
    "trial_court": {
        // these **aren't** the same court codes: they're special and hard coded, and differ between stage and prod
        "tyler_lower_court_code": "78", 
        "tyler_prod_lower_court_code": "98"
        // Only have experience in MA, but see https://github.com/SuffolkLITLab/docassemble-MACourts/pull/38 and https://github.com/SuffolkLITLab/docassemble-MACourts/pull/71
    },
    // only used if the above 3 aren't present
    "interview_metadata": {
        "elements": {
            "interview idk": {
                "elements": {
                    "title": "Housing temporary restraining order",
                    // A list of the Legal Taxonomy codes that this form applies to. (https://taxonomy.legal/)
                    "categories": ["HO-00-00-00-00"]
                }
            }
        }
    },
    "al_court_bundle": [
        { // 0th document is the lead document by default
            "proxy_enabled": true, // required to be parsed
            "filing_type": "456", // the filing type
            "motion_type": "", // optional, not really used in IL outside of cook
            "optional_services": [
                {
                    "code": "456", // code from optional services
                    "multiplier": 2,
                    "fee": 2.05
                }
            ],
            "due_date": "YYYY-MM-DDTHH:MM:SS.000Z",
            "filing_description": "A full user written description",
            "reference_number": "",
            "filing_attorney": "abc123",
            "filing_comment": "",
            // Courtesy copies receive an email notification of the filing when it's accepted
            "courtesy_copies": [
                "my-mom@example.com"
            ],
            // Preliminary copies receive an email notification of the filing when it's submitted 
            "preliminary_copies": [
                "lawyer-assistant@example.com"
            ],
            "filing_parties": [
                "users[0]", "users[1]"
            ],
            "filing_action": "efile", // or "efile_and_serve", or "serve"
            "tyler_merge_attachments": false, // if true, all of the entries in "elements" will be ignored; those attributes will need to be present on this object.

            // If there are multiple parts to this documents (i.e. a main doc and attachments), they should be individual elements
            "elements": [
                {
                    // Attachment attributes
                    "document_type": "123", // the document type code
                    "filing_component": "456", // the filing component, i.e. lead doc or attachment
                    "filename": "something.pdf",
                    "document_description": "The clerk told me this document was needed", // The filer provided description of the document
                    "data_url": "https://our-server.com/secure_pdf/10498274.pdf?key=outher", // the URL where the proxy server can access the PDF"
                    "proxy_enabled": true
                },
                { ... }
            ]
        }
    ],

    "comments_to_clerk": "I worked with clerk John Brown to complete this at the law library.",
    "tyler_payment_id": "12345678-1234-1234-1234-12345678abcd", // retrieved from .../payments/payment-accounts
    "lead_contact": {
        // same as users / other_parties
        "email": "cool_dude1@example.com", // email is required
    },
    "return_date": "YYYY-MM-DD+01:00",
}
```
