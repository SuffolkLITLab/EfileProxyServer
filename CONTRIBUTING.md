# Contributing

## Project Background and Context

This project is a part of the [Document Assembly Line](https://assemblyline.suffolklitlab.org/) as a part of the Suffolk LIT Lab.

This project is primarly meant as an intermediatary between programs that want to e-file document with courts and
E-Filing Managers, specifically Tyler Technologies[^1]. While this project is [open source](LICENSE), we don't have control
over access to Tyler Technologies' servers, which will make it difficult to use or test this software if you aren't a part of
the Assembly Line team.

While we still welcome contributions and can help debug issues and patches, we cannot help with getting access keys from Tyler.
You can reach out to [Tyler's eFile and Serve](https://www.tylertech.com/products/enterprise-justice/efile-serve) team
to learn more. 

## Building and Running

See the [README.md] and [docs/setup.md] for more details on how to build locally, and [docs/developing.md] for technical 
details to keep in mind when writing code.

## Making PRs

To make a PR on our GitHub project, follow [this guide from GitHub](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request).

When you make your PR, don't forget to make sure that your changes pass our
continuous integration (CI). The CI scripts are found in `.github/workflows`,
but in general you should run the following commands before making a PR:

* `mvn -Preproducible verify` (build the Java project)
* `mvn compile javadoc:javadoc` (build the Javadoc documentation)
* `docker build .` (build the Docker image)
* `mvn spotless:apply` (formats your code)


[^1]: While we have intentions of expanding to work with additional EFMs, the only one we work with is Tyler's implementation of ECF 4.