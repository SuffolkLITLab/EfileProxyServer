# Build System for the Java Project

2021-03-26

Author: Bryce Willey

After [ADR 001](001-java-cxf-for-soap.md) chose a new language, the next step is to choose a build
system for that language.

## Considered Alternatives

* Maven
* Gradle
* Bazel
* No build systems

## Decision Outcome

* Maven
* The most widely used
* Not building on Android (the primary place I've seen Gradle being used)
* Don't need the speed of Bazel really, there's a complexity trade off
