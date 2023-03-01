# Build System for the Java Project

Author: Bryce Willey

Date: 2021-03-26

Status: Implemented

After [ADR 001](001-java-cxf-for-soap.md) chose a new language, the next step is to choose a build
system for that language.

## Considered Alternatives

* [Maven](https://maven.apache.org)
* Gradle
* Bazel
* No build systems

## Decision Outcome

We decided to use Maven
* The most widely used
* We only need to build for linux, we don't need to build on Android, the primary place I've seen Gradle being used.
* Don't need the speed of Bazel really, there's a complexity trade off
