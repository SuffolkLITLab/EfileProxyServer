# Developing

See [setup.md](setup.md) to first install the required dependencies and be able to run the server.

## Working with Docassemble

If you are developing integrations to the E-file Proxy on a docassemble server, you need to install
the following packages:
1. [docassemble.AssemblyLine](https://pypi.org/project/docassemble.AssemblyLine/)
1. [docassemble.EFSPIntegration](https://pypi.org/project/docassemble.EFSPIntegration)


## Writing Code

There are two server files that provide important features that can help you understand the server:
* [AdminUserService.java](../src/main/java/edu/suffolk/litlab/efspserver/services/AdminUserService.java).
* [FilingReviewService.java](../src/main/java/edu/suffolk/litlab/efspserver/services/FilingReviewService.java).

TODO: write a separate, full `architecture.md` file.

To add new libraries, edit [`pom.xml`](../pom.xml) and add an entry to `<dependencies>`.
Here is an example of when we added the sendgrid library:

```xml
        <dependency>
            <groupId>com.sendgrid</groupId>
            <artifactId>sendgrid-java</artifactId>
            <version>4.7.2</version>
        </dependency>
```

You can search for dependencies using [Maven's search site](https://search.maven.org/), and see more
details about a package on [MVNRepository](https://mvnrepository.com/).


## General Tips
This [REST/JAX book](https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter3/developing_a_jax_rs_restful_service.html) is a good place to learn about the basics of JAX.
