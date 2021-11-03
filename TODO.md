6/17/21:

Tried looking into Spring, but honestly it seems like a huge mess, and I can't quite wrap my head around how it
should work with CXF. Just going to dump a lot of links here in case we want to revisit ever:
* https://cxf.apache.org/docs/jaxrs-services-configuration.html
* https://cxf.apache.org/docs/springboot.html#SpringBoot-SpringBootCXFJAX-RSStarter
* https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans
* https://github.com/apache/cxf/blob/master/distribution/src/main/release/samples/jax_rs/basic_https/src/main/resources/ServerConfig.xml

Open questions we should answer before using Spring:
1. Do we feel like we actually understand how to use Spring? It's not useful if literally no one gets it.
2. Is our own config file format going to implement too much of Spring? Specifically, the mapping of
   jurisdictions to URLs and the Filing Classes to use
3. Alternatively, is Spring too complicated for our use case?