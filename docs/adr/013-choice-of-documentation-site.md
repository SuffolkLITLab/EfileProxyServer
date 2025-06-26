# Choice of Documetation Site Framework

Author: Bryce Willey

Date: 2025-06-25

Status: Decided, In progress 

While we have various ways of generating and viewing docs locally (manually
building javadocs, using [enunciate](008-choice-of-rest-docs.md) to view REST
endpoint docs), there's no easy way to access this information if you don't
have a local development environment set up (i.e. new developers or folks who
don't work on this repo much).

We should host this information on a documentation site that is easily findable and
accessible. The only real choice for where to host it is on GitHub pages, and
IMO it should be separate from the rest of the [Assembly Line documentation](https://assemblyline.suffolklitlab.org/docs/overview).
This ADR focuses on how to generate the static HTML that will be hosted on
GitHub pages.

## Considered Alternatives

* `mvn site` and the maven-site-plugin
* `docsite`: https://github.com/luiinge/docsite-maven-plugin?tab=readme-ov-file
* `jekyll`, the default / best supported static site generator for GitHub pages
* `mkdocs`: https://www.mkdocs.org/
* `docusaurus`, what we use for the Document Assembly Line documetation

## Decision Outcome

**mkdocs**

* `+` it Just Works. Out of all of the options tried, needed the least
  customization, and no moving of documetation files.
* `+` lets us easily add links to other URLs (necessary to include externally
  generated javadocs and Swagger API docs)
* `+` built on python, so not too much of a lift compared to other choices
* `-` is a new documetation generator compared to what's already available
* `-` not the biggest fan of either of the themes, but they're good enough and
  there are [alternate themes available](https://github.com/mkdocs/catalog?tab=readme-ov-file#-theming)

## Pros and Cons of the Alternatives <!-- optional -->

### maven-site-plugin

* `+` already built into maven
* `-` unintuitive layout and navigation, doesn't emphasize the right things
* `-` would have to move markdown content to `src/site/markdown`, a very
  confusing place to put documentation when simply browsing the project.
* `-` cumbersome to use and try to find documentation for (maven has lots of
  documentation, but little of it is immediately usable, or could serve as a good reference)
* `-` not aesthetically appealing

### docsite

* `+` a better alternative to maven site, can use a maven plugin
* `-` had conflicting errors with multi-module projects
* `-` still some wonky-ness when trying to include a docs folder

### jekyll

* `+` the best support when trying do stuff on GitHub pages (prebuilt actions,
  etc.)
* `-` almost all Jekyll themes don't have good navigation
* `-` still quite a bit of extra setup to get things set up, without adding a
  lot of extra config and `_layout` dirs, etc.

### Docusaurus

* `+` already used by other Suffolk projects
* `-` too heavy-weight for this project, still lots of config
