# ECFv5 TODO list

## WIP

* [ ] use the SOAP web services (• https://illinois-stage.tylertech.cloud/efm/EFMFirmService.svc?wsdl
• https://illinois-stage.tylertech.cloud/efm/EFMUserService.svc?wsdl
• https://illinois-stage.tylertech.cloud/efm/v5/CourtRecordService.svc
• https://illinois-stage.tylertech.cloud/efm/v5/Service.svc
• https://illinois-stage.tylertech.cloud/efm/v5/FilingAssemblyservice.svc
• https://illinois-stage.tylertech.cloud/efm/v5/filingreviewservice.svc)
  and make a call to GetPolicy. "For the WSDL you will need to consult EFM documentation as ECF5 spec is utilizing URI to load the schema. URI uses the file storage path.


## Codes changes
* [ ] courts: add `partialwaiverdurationindays`, `partialwaivercourtpaymentsystemurl`, `partialwaiveravailablewaiverpercentages`
* [ ] filing codes: `iswaiverrequest`
    * Indicates whether the filing code is configured to request a standing waiver from the court.

      The request is specific to the filer and the case. If a waiver request is granted, it will be for a limited duration. The reviewer will receipt the filing to acknowledge that they have received the waiver request. Thereafter, the court will decide whether to grant or deny the waiver, and if granted, whether in part or in full. If granted, the filer will be able to file into that case and automatically receive the percent waived until the waiver expires. Any non-waived fees must still be collected; therefore, the filer must provide a non-waiver payment account when a partial waiver is in effect. Implications for the use of waivers are provided below:

      1. Per Envelope waivers waive all fees for the envelope, including court fees, Tyler fees, and provider fees.
      2. The system will not allow the filer to use a Per Envelope Waiver if the filer has an active Standing Partial Waiver for the case.
      3. Any payment type will be allowed if there is no active standing waiver .
      4. Partial standing waivers waive court fees at the percentage granted by the court.
      5. Partial standing waivers do not waive Tyler fees.
      6. Partial standing waivers do not waive provider fees.
      7. Full standing waivers waive Tyler fees.
      8. Full standing waivers waive provider fees.
      9. If a waiver request is denied the system does not prevent additional waiver requests.

## Admin
* `isActivated` on Register response
* Payment accounts: waivers, draw down accounts, cash accounts (recommend we filter them out?! WTF?)
* Payment accountList: `isAvailabelAtAllLocations`, `AvailableLocationNodes`
* Authentication Request: everything Okta: `passwond` should contain the JWT returned from Okta instead of user provided password
* GetUser: Role: and the "Composable Security Model" (in the GetPolicy).
* GetNotificationPreferences: output now includes ACCOUNTLOCKED, and RETURNFORCORRECTION

## Efiling APIs
* CourtPolicy is in a separate MDE.
  * A lot has changed here
* Tyler Extensions of Court Record and Court Scheduling MDEs
* Fees structure looks different?
* Review filing is different too.
* GetFilingList can take in Filing status, case number, and envelope number inputs now too
* GetFilingStatus is one call now; no separate details API
  * this can stay the same in ours, and just default to calling the other

## Generally how to run both
* on restart, use the ECFv5. Will have to change over each. Lots in the EFSPServer start loading that needs to change
* returns a completely different structure: what to do on the EFSP side for that?
  * [ ] to try: just get some of the responses coming through, and see how different they are. Likely will just need different
    parsing by the python side. Not a good way to abstract things, and I don't like having another interface between everything.
    Adding one would require much of the same migration stuff on the python side. Not a fan.


## ECFv4 changes, but still needed

### Codes changes
* [ ] courts: add `autoassignsrlservicecontact`, `autoassignattorneyservicecontact`, 
* [ ] datafields: SearchLocationFilter: "provides requirements regarding whether a court location is required when preformating a case search" (default true)
* [ ] refund reason codes
