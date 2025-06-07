# Use Papertrail to Increase Access to Logs

## Context

Logs are viewable within Fly.io. Access to those logs is constrained to authorized users. However, this permission is not fine-grained and authorized users also have the power to perform administrative actions. 

**User Story:**
As a Suffolk LIT Lab operator, I want to share access to logs with stakeholders who can benefit from being able to self-diagnose any issues using the EFSP API. 

## Decision

Integrate Papertrail through the existing slf4j/logback stack as a log appender option, using TLS-encrypted syslog over TCP. If the Papertrail environment variables are set (see env.example for details), the logs will also be forwarded to Papertrail. Papertrail will serve as a central point of access for viewing the logs. The Papertrail UI makes it easy to filter and search through the logs. Being able to control log access independent of access to more admin operations within Fly.io makes for better security. Separating out the logging concern allows you to ship logs from other environments besides Fly.io as well. For example, the logs from Lightsail instances can be fed into the same dashboard. The current staging and production Fly.io instances will all forward to a single Papertrail dashboard and identified by the system and configurable application name.

## Alternatives Considered

1. Using the Fly.io log shipper
  * Pros
    * Closer to the platform
  * Cons
    * Requires having extra machines running the log shipping at all times
    * For one-off runs, the usage is clunkier because output has to be redirected to /dev/console for it to be picked up 
2. Observability platforms such as Splunk or Datadog
  * Pros
    * More complete offerings/advanced features
  * Cons
    * Much more expensive
3. Using a token-based Papertrail appender
  * Pros
    * Better identification of the senders
  * Cons
    * Not the recommended option by Papertrail for Java apps
    * Less performant
    * Likely requires some Java code to implement the token appender