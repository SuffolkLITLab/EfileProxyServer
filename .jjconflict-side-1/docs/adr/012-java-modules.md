# Use Java Modules for each implemenation of ECF 

Until now, all code has been in a single Java project, the EfileProxyServer. I've done my best
with Java packages (i.e. namespaces), but handwritten code gets mixed up with `wsdl2java` generated
code, and there's little room for multiple versions of code to deal with Tyler's multitude of server
versions and the different schemas they use.

The ultimate forcing function is that currently, there's an API call that is broken in most
jurisdictions of Tyler (#211). However, merging that PR as is would break production in
Massachusetts because Tyler is running a much older version of their software in Massachusetts
(2022.1). To actually merge a fix that fixes us in all jurisdictions, we need a solution to handle
multiple API versions in the same package. This requires a more solid interface between the Java
code we use as client to Tyler's systems and our own proxy server code.

Separate maven projects, in the form of Java modules, is the best approach for this. But I'm still
trying to decide what modules to make, and how to split the code up amongst them.

## Considered Alternatives

All solutions separate out our proxy server code into it's own module, `proxyserver`.

For the remaining code, here are the options:

* one per EFM implementation: i.e. one for Tyler, and one for TrueFile (when implemented)
* one per EFM server: i.e. one for Tyler ECF4, Tyler ECF5, TrueFile ECF5, etc.
* one per EFM client specification: i.e. one for Tyler's EFM APIs, Tyler ECF4, Tyler ECF5, TrueFile
* one per EFM specification and server implemenation: i.e. one for Tyler's EFM APIs, ECF 4, Tyler's implementation of ECF 4, etc.

## Decision Outcome

**One per EFM client specification**

The best working solution: some duplication between different impmelementors (Tyler / TrueFile,
etc.), but slightly less within Tyler implementations.

## Pros and Cons of the Alternatives <!-- optional -->

### One per EFM implementation

* `-`: too simple
* `-`: doesn't handle the fact that even within Tyler, there are two official clients: ECF4 and ECF5.
* `-`: also doesn't account for different versions of the same clients (i.e. 2022.1 and 2024.4).

### One per EFM Server

* `+`: the simplest working solution
    * you are pointing to this specific server? Use this library
* `-`: Tyler's EFM API (get users, attorneys, etc.) is the same between ECF4 and 5
  (like actually the same endpoints and everything), so it would have to be duplicated between ECF4 and 5 projects.

### One per EFM specification and server implementation

* `+`: IMO, the best possible option, with the least amount of duplication.
    * Still as simple as One per EFM Client specification", but less code in the implentation projects.
* `-`: because of how JAXB XML - Java binding works, extensions / substitutions / replacements for
    specific XML objects by Tyler / etc. need to be specified in the original class.
    * therefore, implementor classes need to be in the original package as well, can't be split out.
