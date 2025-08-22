# Using the REST interface: a guide

While most of Suffolk's work is on [docassemble](docassemble.org) and integrates with this server using [docassemble-EFSPIntegration](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration), it is possible to directly call this server using the REST endpoints. This high-level guide lays out the best order to make those calls, and where to look for more details on what data to send.

Note that all of these endpoints start with `/jurisdictions/{jurisdiction_id}`, in order to handle the different jurisdictions like Massachusetts or Illinois. These will be replaced with `...` to focus on the unique parts of the endpoints.

## Headers for all calls

There are several headers that you will need to pass on all or most of your calls to the proxy server.
Note that all HTTP headers are case insensitive, i.e. `X-API-KEY`, `X-Api-Key`, and `x-api-key` are equivalent.

* `X-API-KEY`: the API Key to the proxy server. This will be given to you by the server admin.
* `TYLER-TOKEN-{jurisdiction}`: Once you have authenticated an user with the `/authenticate` endpoint, you'll recieve back this key-value pair in the JSON response. It should be put in the Headers as you receive it in order to complete other actions as that user, such as administrative tasks, case searches, and making filings into cases.
    * For example: `TYLER-TOKEN-ILLINOIS: bwilley@suffolk.edu:eb5cf7fd-...` (with a full UUID)
* `efsp-session-id` (optional): a UUID that gets included in all log messages. Intended to be the same UUID for an entire user "session" on the client's side (e.g. a whole docassemble interview).
* `efsp-correlation-id` (optional): a UUID that gets included in all log messages. Intended to be the same UUID for all calls needed to generate a specific page, i.e. what the client would consider as a single operation.
* `efsp-request-id` (optional): a UUID that gets included in all log messages. Should be different for each call (if not included, on will be generated for you).

## Account creation and login

TODO

## Case search and parsing

TODO

## Query court codes

TODO

## Query / create payment types

The two main ways that filers can pay the court are with waivers and with other methods (credit cards, banks, etc.). Waivers are usually accompanied by a document the filer completes to
demonstrate to the court that they need a waiver (see [the section on submitting](#calculate-payment-check-filing-and-submitting)).
Since waivers don't require the user to enter sensitive information, their creation
is simpler than other methods.

To create a new waiver, you can `POST` to [.../payments/payment-accounts](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/createWaiverAccount) with the desired waiver account name as the request body, and it
will be created. The court will later verify the status of this waiver when reviewing
the user's filing (TODO: some currently unsupported jurisdictions have a more complicated process).

To create new payment methods other than a waiver, like a credit card or bank account,
Tyler requires that users enter their payment information on their site for security
reasons. The steps are as follows:

1. The user's browser should make an XML form submission to [.../payments/new-toga-account](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/redirectToToga). This submission will forward the user to this server, which will save the submitted information and make an additional forward to Tyler's payments page. See [this working example](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration/blob/85d9222eb0f4e7a6e74b04c7950efe689d81e3cc/docassemble/EFSPIntegration/data/questions/toga_payments.yml#L64-L105) for some JavaScript that should work. The params that need to be passed in the form submission:
    * `account_name`: what the name of the account should be (i.e. "Personal checking")
    * `global`: should usually be `false`
    * `type_code`: the code for the type of payment account that's being created. This
        should be pulled from [.../payments/types](https://projects.suffolklitlab.org/EfileProxyServer/endpoints/ui/index.html#/JurisdictionSwitch/getPaymentAccountTypeList).
    * `tyler_info`: the token that usually goes in the `TYLER-TOKEN-{jurisdiction}` header, but has to go here since the user's browser is completing the query.
    * `original_url`: the URL that the user should be redirected to on a successful payment account creation.
    * `error_url`: the URL that the user should be redirected to on a failed payment account creation.
2. On Tyler's payment page, the user will securely enter their payment information.
3. After the user submits their payment information, Tyler's page will forward the user back to this server, which creates the payment account, and then, depending on if the process succeeds or fails, will forward the user to one of two given URLs where your client can handle the status of the process. 

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
                    "proxy_enabled": true,
                    // Need to precalculate this
                    "page_count": 1
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


    "cross_references": {
        // The keys are the cross reference codes
        "87374": "99502",
        "76343": "12345"
    },
    "amount_in_controversy": "103.43",
    // Used for return_date / court scheduling
    "out_of_state": false,
    // Optional metadata about the filer, no bearing on e-filing functionality
    "filer_type": "429",
    // Some locations let you set an amount that you are willing to pay, to allow the reviewer to adjust / correct your filing, even if it would be more expensive. Optional.
    "max_fee_amount": "200.00",
    // The procedure remedy code (e.g. garnishment, class action).
    "procedure_remedy": "669",
    // The damage amount code (e.g. "under $1000, etc.)
    "damage_amount": "670",

    // Per filing you can customize the email response that your users will get. You can put the email subject / body HTML for the possible responses in these variables.
    "email_confirmation_subject": "Your filing was submitted",
    "email_confirmation_contents": "<html><body><h1>Your Filing was submitted</h1>...</body></html>",
    "acceptance_subject": "Your filing was accepted",
    "acceptance_contents": "<html><body><h1>Your Filing was accepted</h1>...</body></html>",
    "rejected_subject": "Your filing was rejected",
    "rejected_contents": "<html><body><h1>Your Filing was rejected</h1>...</body></html>",
    "neutral_subject": "Your filing was responded to",
    "neutral_contents": "<html><body><h1>Your Filing was responded to</h1>...</body></html>"
}
```
