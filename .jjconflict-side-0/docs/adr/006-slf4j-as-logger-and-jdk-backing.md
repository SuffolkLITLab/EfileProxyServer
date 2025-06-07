# Logger Library Choice

Author: Bryce Willey

Date: 2021-07-19

Status: Implemented, overridden by [ADR 007](007-logback-as-logger-backing.md)

We need to have some sort of logging system by the time we are running in production, as
`System.err.println(...)` is a bit difficult to introspect after the fact, and those logs
can easily get swamped in other, less useful prints.

Most of the actual advice here was from [this blog](https://sematext.com/blog/java-logging).

## Considered Alternatives

* SLF4J + something else
* JDK Common logger (java.util.logging)
* Log4j (2)
* Logback

## Decision Outcome

SLF4J + JDK Common Logger
* Given my inexperience with logs, being able to switch out backends is very useful, and we
  will change from all of the `System.err.println` calls to something else anyway.
* JDK is the simplest backing logger, so sticking with it for now.
* Config files have yet to be setup consistently, so I still need to look into that.
