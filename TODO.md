
5/23/2022:

* Filter / authentication for all of the endpoint calls
  https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-2rd-edition/content/en/part1/chapter12/server_side_filters.html
* VisualVM to check for memory usage when running and making filings
  https://stackoverflow.com/questions/35108868/how-do-i-attach-visualvm-to-a-simple-java-process-running-in-a-docker-container
  https://visualvm.github.io/gettingstarted.html?VisualVM_2.1.3
  

5/20/2022:

Full auto integration test:

* docker-compose-test file:
  * starts up docassmble, postgres, and EFSP
    * db init for PG: https://stackoverflow.com/questions/36781984/load-postgres-dump-after-docker-compose-up
      * tyler_efm_codes_v0_1_truncated.tar.xz
  * start docker-compose
  * from an npm container
    * wait til DA is up
    * add the EFSP server API key (maybe hard coded from the user_transaction.sql) to DA config
    * install & playground install IL, Jeffnet & EFSPIntegration
    * run feature files for all 3 packages



5/16/22:

Maybe eventually https://neilmadden.blog/2018/08/30/moving-away-from-uuids/


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

