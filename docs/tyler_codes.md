# Tyler EFM Codes

Author: Bryce Willey

TODO(brycew): Still in prgress!

Tyler codes are simply options that the end-user must make (either implicitly or explicitly) when making a filing. The choices are essentially a drop-down list of options, defined by the court and other choices they have made so far in the filing process. Each court decides which codes are available to it's filers, and every court differs.

Technically, Tyler describes it's codes using the [genericode](https://docs.oasis-open.org/codelist/cs-genericode-1.0/doc/oasis-code-list-representation-genericode.html#_Toc190622786) standard, as is required by ECF. Only a small subset of the features of genericode are used however. Most of the information about the codes can be expressed as a SQL table, as is natural for genericode: each code has one or more columns and each entry in a code is a row.

This is not meant to be an exhaustive description of each column in all of the codes: it is an introduction into the hierarchy of the code tables, with a brief description of each.

The codes system has 45 different codes:
* answer
* arrestlocation
* bond
* casecategory
* casesubtype
* casetype
* chargephase
* citationjurisdiction
* country
* crossreference
* damageamount
* datafieldconfig
* degree
* disclaimerrequirement
* documenttype
* driverlicensetype
* error
* ethnicity
* eyecolor
* filertype
* filetype
* filing
* filingcomponent
* filingstatus
* generaloffense
* haircolor
* language
* lawenforcementunit
* location
* motiontype
* namesuffix
* optionalservices
* partytype
* physicalfeature
* procedureremedy
* question
* race
* servicetype
* state
* statute
* statutetype
* vehiclecolor
* vehiclemake
* vehicletype
* version

Many of these codes are applicable for criminal cases only, and aren't used in our system (see #todo). These are:
* answer: QuestionAnswer in ReviewFiling
* arrestlocation
* bond: relates to CaseChargeBondAmount, CaseChargeBondType, and BondTypeText in ReviewFiling
* chargephase: in ReviewFiling Criminal
* citationjurisdiction
* degree: statutelevelchange
* ethnicity
* eyecolor
* general offense
* haircolor
* lawenforcementunit: EnforcementOfficialText
* physicalfeature: personphysicalfeature, and physicalfeature* vehicletype, i.e. Four Door, 34 PU, Moped, etc.
* question: QuestionAnswer in ReviewFiling
* race: PersonRaceText in ReviewFiling
* statute
* statuetypes, a whole lot, lol
* vehiclecolor
* vehiclemake
* vehicletype

The rest are described below, starting with the top of the hierarchy, down to the bottom of the hierarchy.

## System codes

System codes are technically not dependent on any specific court, and are available system wide. In practice, most of these codes can be changed on a per-court basis, so it's not wise to only get the system codes.

### Location

The top level of the hierarchy, the location code is just the court location. It might be either an individual court building, or a collection of different court buildings acting as a cohesive unit. There are also individual levels within the location codes. Informally, this is something like "cook" having it's only entry in the codes, but "cook:chd1", or chancery district 1, being a under the cook location, with it's own codes. Formally, this is described in the `parentnodeid` column.

### Error

The error codes describe all possible error values that an API call can get back from any API call to Tyler. In practice, these codes are only useful in aggregate, as they give no more information that you would get at runtime when those errors are actually received, and you have more contextual information about how to handle the error at runtime than you do when reading the error codes table.

### Country and State

A list of countries recognized by country fields. The State codes are available for a select number of countries: for IL these are only Canada, the US, and Mexico.

### Filing status

### Version

### Data Field Config

This code is one of the more important codes: it lists every piece of information that it expects your EFSP UI to ask for, whether each is to be shown to the user, required from the user, and if it needs to follow a specific regex, as well as the error message to be shown if it doesn't follow the regex.

## Location Level Codes

These codes aren't available system-wide, but only depend of the location/court that the user is interacting with.

### Service Type

### Disclaimer Requirement

Certain courts have disclaimers that users are required to be shown and generally acknowledge / accept. The text of those disclaimers are in this code table.

### Language

Which language the filer or any specified party speaks or prefers to use.

### File Type

The types of the digital files that are accepted at this location. For example, PDF or DOCX.

### Name Suffix

What suffixes are allowed in the names of users.

### Filer Type

### Driver License Type



## Filing Specific Codes

These codes are generally the most relevant to the court and the filing being made, and thus are the most structured and differ the most from court to court.

Their hierarchy is shown in the below image.


![The dependencies of the filing specific codes, as a directed graph](code_dependencies.png)


### Case Category

The case category is a broad select across different groups of cases, ranging from as wide as Civil or Family, to narrower categories like Eminent Domain to Dissolution (Divorce) with Children to Contempt of Court. It also declares if two other code tables, Damage amount and procedure remedy, are available to cases of that category.

### Damage Amount and Procedure Remedy

? (not used in IL, have no examples)

### Case Type and Subtype

The actual and more specific type of the case being filed. For example, in Adams county, the case types for the case category "Eminent Domain" are:
* Eminent Domain (started within the court, not allowed to be initiated by an e-filer)
* Eminent Domain (allowed be the initiated by an e-filer)
* Condemnation (N)
* Change of Venue - Eminent Domain

There are often case types that look identical until you filter by if they are allowed to be initiated by an e-filer. Those are allowed usually have an additional fee to initiate, whereas those that don't have no additional fee to make a subsequent filing.

### Cross Reference

A general number that references some other schema or database elsewhere. The most commonly used on in IL is the Cook County Attorney/Self-Represented Litigant Code, which each attorney will know, and if the filer is an SRL, needs to be a specific number, 99500. Cases can generally require an arbitrary number of these cross references.

### Party Type

The parties that are allowed to be in a case type. The most common of these are Plaintiff/Petetioner and Defendent/Respondent, but other ones include Guardian, Minor, Executor, Ward, etc.

### Filing

The actual filing type being made. Determined by what case type the filing is being made into, as well as if this in an initial or subsequent filing into the case. The remaining codes below are all dependent on the filing code.

#### Filing Component

#### Motion Type

#### Document Type

#### Optional Services



