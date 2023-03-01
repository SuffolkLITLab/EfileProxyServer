# Documentation Site

Author: Bryce Willey

Date: 2023-03-01

Status: Decided, in progress

In order for our stand-alone REST server to be useful, we need some sort
of developer documentation. There are lots of different options of how to
document a Java REST server, and need to choose and focus on one.

## Considered Alternatives

* javadoc and `mvn site`
  * Will create a Javadoc site that describes each method on each class in our code
* SwaggerHub
* [OpenAPI Generator](https://openapi-generator.tech/): can generate an HTML site
* [Doing it the "RESTful" way](https://stackoverflow.com/a/1970020/11416267)
  * i.e., no documentation, everything is always linked in every response to the URL.
* [Enunciate](http://enunciate.webcohesion.com/)
* [WADL](https://stackoverflow.com/a/2294364/11416267), or SOAP for REST

## Decision Outcome

[Swagger-maven-plugin](https://github.com/swagger-api/swagger-core/tree/master/modules/swagger-maven-plugin) and [OpenAPI's HTML Generator](https://openapi-generator.tech/)

* the swagger maven plugin will generate an OpenAPI YAML specification in `openapi.yaml`, that lists all of the endpoints and what inputs they take
* OpenAPI's HTML generator turns that into a webpage.
* We will have to add [specific Annotations](https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Getting-started) to our services
  to describe them, as javadocs don't seem to be picked up. Unfortunately, we don't have a lot of schemas, so we will have to manually describe
  a lot of the datatypes that people send to us.
  * we can't really describe the datatypes with Java schemas, since none of them support Optional, and it's not clear what fields are required
    or not without it.

### Still to be decided

* This is only the reference API: how will it be connected to guides or concepts or other documentation, if present?

## Pros and Cons of the Alternatives

### javadoc and mvn site

* `+` a part of pretty much every java project, and already present for us, no extra plugins needed
* `+` [according to maven](https://maven.apache.org/guides/mini/guide-site.html), you can easily add markdown content. Might be a thing we use later, to write guides, but we'll have to see
* `-` the documentation is very class-oriented. This structure focuses on classes and methods, which works when documenting libraries, but doesn't work well when documenting web servers, which have specific endpoints.
* `-` personal opinion: the default site is horrible, both aesthetically and usability-wise. Nothing is organized well, a lot of the defaults of the maven side of the site (which is where the guides would live) are bad (small font sizes, weird emphasis on the dependencies of the project, etc.)

### SwaggerHub

* `+` generally nice UI
* `-` the LITLab already is using one SwaggerHub site with SPOT, and we only get one free site
* `-` there's an emphasis on "interact with the server now", which we aren't designed for, and IMO won't work well

### Doing it the "RESTful" way

* `+` nothing to document!
* `-` lots of additional work to be done on the java side to support all of the things that you would need to know when navigating each endpoint: the expected inputs, example inputs and expected outputs (especially for submitting IRL things)
* `-` we've already done it; everything under the `codes` endpoint kinda works like that, and TBH no one wants to do that. Only works on Firefox (Chrome won't show you links in JSON), and I'm not supporting returning full HTML
* `-` TBH, we just weren't always able to design a fully RESTful API, and this very much seems like the "self-documenting code" dream that doesn't exist

### Enunciate

* `+` looks a bit lighter weight than the OpenAPI generation
* `+` scoped well: more focused on HTML documentation
* `-` no example pages to see what the result looks like
* `-` the [sample project](https://github.com/stoicflame/enunciate-sample) itself is poorly documented if you aren't fluent in Maven
* `-` requires us to change our maven packaging to `war` instead of the default `jar` for some reason. Not a fan of that
* `-` Doesn't work with JDK 17; support is focused on JDK 8, and apparently [2.15.0-SNAPSHOT fixes this](https://github.com/stoicflame/enunciate/issues/1087), but it's not released on maven yet, and would require us to build from source.

### WADL

* `-` absolutely not, I am not subjecting our users to SOAP-like nonsense to use our server
