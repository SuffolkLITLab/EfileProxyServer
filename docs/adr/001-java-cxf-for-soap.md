# Use Java and CXF to communicate over SOAP 

Author: Bryce Willey

2021-03-25

The main purpose of this project to create an application that allows Docassemble interviews 
to e-file with Tyler Technologies as an E-Filing Service Provider (EFSP). Tyler implements
the ECF v4.0 standard, which is defined using XML and SOAP services. Thus, the choice
of what software to use to communicate over SOAP is a vital decision. It needs to be
reliable, have some longevity / be maintained, and be relatively easy to use, as none of
us are SOAP experts. The decision also needed to be made relatively early on in the lifetime 
of the project, as much of the rest of the software will depend on it working.


The following were our discovered choices.

## Considered Alternatives

* a SOAP library in Python
* Using Java and a library:
  * CXF
  * Apache Axis
  * JAX-WS + JAX-RS
* using C# and Microsoft's SOAP capabilities

## Decision Outcome

We chose to use Java and CXF.
* Java over other languages: python's Zeep library doesn't have MTOM optimization, which is required, and C#'s .NET Core (or .NET 5.0) doesn't seem to support MTOM and some other aspects of SOAP as well.
* CXF over other Java libraries: Axis doesn't seem to have good reviews, and JAX-RS isn't fully featured

Consequences:
* Need to standup a separate proxy server, with a very different tech stack than DA normally has
* Will need to also setup docker-compose and some additional items as well

## Pros and Cons of the Alternatives 

### Python with a SOAP Library

* `+` People working with Docassemble already know python
* `+` A python extension for Docassemble is the most likely to be adopted by many users
* `+` A python extension would keep the project much simpler, with fewer moving parts
* `+` Zeep, the SOAP library of choice, is pretty well documented and easy to use
* `-` Tyler did not mention that python was a popular choice among people becoming EFSPs, suggest less support
* `-` We could not get Zeep to work with Tyler's SOAP server, and Tyler was not able to help us overcome those issues, despite the Envelope looking correct
* `-` Zeep does not support MTOM (Message transmission optimization mechanism), where binaries are not encoded in base64 but instead are placed at the end of the SOAP message directly in binary. Tyler requires clients to MTOM. This could be the reason that Zeep wouldn't work with the SOAP server, but it's unclear.
* `-` A docassemble specific extension would limit the potential audience, and HotDocs and A2J author wouldn't be able to use it

NOTE: In June of 2021 I came across [pysimplesoap](https://github.com/pysimplesoap/pysimplesoap),
which could have been an alternative to the Zeep Library, but was discovered too late into
development. On a brief look, it is lightly maintained, and I'm not sure if it has all
of the features necessary.


### Java with a SOAP Libray

* `+` Other EFSPs used Java to implement their software, proving that it can work in production 
* `+` Tyler themselves mentioned that Java's SOAP code generation tools were better than C#, and had fewer bugs in the generated code. 
* `+` Bryce has experience writing Java, and though rusty, is much more comfortable in it than C#
* `-` Would still require a separate server from DA

#### Apache CXF

[Documentation](https://cxf.apache.org/docs)

* `+` seems te be well supported: many of the bugs that I've seen linked in older Stack-Overflow questions have
  actually been fixed since. [An example](https://issues.apache.org/jira/browse/CFX-3452)


#### Apache Axis

* `-` Has lower security ratings from [IBM](https://web.archive.org/web/20150907224548/http://www.ibm.com/developerworks/java/library/j-jws19/j-jws19-pdf.pdf)
* `-` found lots of [complaints about actually using it](https://ruby-vs-java.blogspot.com/2007/01/elads-adventures-in-java-webserviceland.html)


#### JAX-WS

* `+` The standard for Java libraries implementing web services
* `-` Doesn't seem to have complex WS-\* things like WS-Security or WS-Policy, needed for communication with Tyler


### C# and built in SOAP Capabilities

* `+` C# is the only choice here that has SOAP builtin to the standard library. So it's likely to not have support dropped.  
* `+` Tyler has provided a minimally working C# implementation that can login a user. 
* `+` I think Tyler themselves use C# (they've mentioned working with Microsoft tooling elsewhere), so the chance of SOAP library incompatibilites is lower
* `-` No one on our team (Quinten, David, Bryce, or any volunteers) have strong C# or .NET skills
* `-` There was an issue with the C# working example working on .NET CORE / .NET 5.0 (the cross platform version of .NET). This means we would either need significant C# knowledge to work through the issues, or we would need to pay for and host a windows VM / container to run the server on.
