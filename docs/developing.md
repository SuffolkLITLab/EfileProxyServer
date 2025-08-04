# Developing

See [setup.md](setup.md) to first install the required dependencies and be able to run the server.

## Working with Docassemble

If you are developing integrations to the E-file Proxy on a docassemble server, you need to install
the following packages:
1. [docassemble.AssemblyLine](https://pypi.org/project/docassemble.AssemblyLine/)
1. [docassemble.EFSPIntegration](https://pypi.org/project/docassemble.EFSPIntegration)

See the docs for the [docassemble-EFSPIntegration](https://github.com/SuffolkLITLab/docassemble-EFSPIntegration/) package at the main [Assembly Line documentation](https://assemblyline.suffolklitlab.org/docs/components/EFSPIntegration/overview).

## Writing Code

There are two server files that provide important features that can help you understand the server:
* [AdminUserService.java](../src/main/java/edu/suffolk/litlab/efsp/server/services/AdminUserService.java).
* [FilingReviewService.java](../src/main/java/edu/suffolk/litlab/efsp/server/services/FilingReviewService.java).

See [architecture.md](architecture.md) for a description of the general architecture of the program.

### Adding Libraries

You can search for dependencies using [Maven's search site](https://search.maven.org/), and see more
details about a package on [MVNRepository](https://mvnrepository.com/).

To add new libraries, edit [`pom.xml`](../pom.xml) and add an entry to `<dependencies>`.
Here is an example of when we added the sendgrid library:

```xml
        <dependency>
            <groupId>com.sendgrid</groupId>
            <artifactId>sendgrid-java</artifactId>
            <version>4.7.2</version>
        </dependency>
```

### General Tips
This [REST/JAX book](https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter3/developing_a_jax_rs_restful_service.html) is a good place to learn about the basics of JAX.

### Committing your code and making PRs

We accept code and doc contributions! Below are the technical details that will help
your code fit right in. The [full context of this project](../CONTRIBUTING.md) might
help you understand our goals / non-goals.

#### Formatting code

Code formatting is done with [Spotless](https://github.com/diffplug/spotless/tree/main?tab=readme-ov-file#%EF%B8%8F-spotless-for-maven).

```bash
mvn spotless:apply
```

Formatting checking is automatically run whenever `mvn compile` is run.

#### Linting the code (Optional)

We (sometimes) use [Spotbugs](https://spotbugs.readthedocs.io/en/latest/introduction.html#) as a java linter, but it's not strictly enforced at the moment. To find linter errors, run this:

```bash
mvn spotbugs:spotbugs
mvn spotbugs:gui
```

The later command will open a GUI to see all of the bugs that it's found.

