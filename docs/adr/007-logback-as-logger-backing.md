# Logger Backing Library Choice: Pt 2

Author: Bryce Willey

Date: 2022-08-16

Status: Implemented

An issue that we consistently have with logging is trying to turn off logs
from certain packages that we can't control and make a lot of unnecessary noise in the logs (there's one from CXF that just isn't useful).

Unfortunately, the JDK common logger (i.e. java.util.logging, or JUL) doesn't not seem to work for this case. If it does, it's not documented well enough for me to figure it out, and Java code is fairly difficult to read on your own. Either way, we need a different logging backend that will let us filter out these noisy logs.

The good news is that per [ADR-006](006-slf4j-as-logger-and-jdk-backing.md),
we have the ability to easily change our backing logging library, without changing the code; we only need to change what library is installed, and
the configuration file.

## Considered Alternatives

* Log4j: not going to consider after their security fiasco
* `java.util.logging`: could not get it to work
* Logback

## Decision Outcome

Went with Logback.

Logback has (comparatively) [better documentation](https://logback.qos.ch/manual/index.html), and we were able to easily change the level of the logs
coming through from other libraries with a single line in the config:

```xml
  <logger name="org.ehcache.core.EhcacheManager" level="ERROR"/>
```