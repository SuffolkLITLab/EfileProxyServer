# Exposing Logs to API Users

**User Story:** We want to expose logs on this proxy server to developers and API users of the proxy.

This is necessary because the interview devs need this info (both internal logs that show what happens when they call the API, and the logs when Tyler calls us about their cases), not us as the proxy maintainers. But the proxy server can't automatically deliver things to DA servers for convenient viewing.

This is really a series of several different decisions, each of which is separated into considered alternatives, outcomes, and pros and cons below.


## How to record the info

### Considered alternatives for recording

1. Manually, through our own system and internal API, adding things that we'd want to log when necessary
    * pro: can be very specific about what we log
    * con: a huge amount of likely duplicate coding with the logs
2. Use MDC from slf4j, which lets us tag each log message with an entity (the server name, and eventually the specific interview session ID)
    * pro: get all of the logs for free!
    * con: more tightly couples us to logback, making slf4j less useful. See [the logback ADR](007-logback-as-logger-backing.md) and [the slf4j ADR](006-slf4j-as-logger-and-jdk-backing.md).

### Decision

Went with 2, using MDC. Was a little bit of learning, but definitely useful and still very flexible on what we can do with the log data (see the ServerSpecificAppender.java file).

## Where to save the info

### Considered alternatives for saving

1. In the logs, filtering back out when we want to see it
    * pro: dead simple, what we do now
    * con: still makes us (Suffolk) the manager of the data, and when users want specific data, they have to go through us.
2. in a file, only internal to the server
    * pro: the file exists, still pretty simple, when we want it we can save it
    * con: docker container is even less ephemeral, and we lose all of those server specific logs when we restart / update
3. in a separate external file (likely in a docker volume)
    * pro: file is always there, even with restarts
    * con: more volumes, we already have quite a few

### Decision

Currently implemented 2, in a file internal to the server, but would like to get to 3. Still TODO.

## How to retrieve the info

### Considered alternatives for retrieving

1. with an API endpoint, with the server's API key as a required header or param
    * pro: the same API key, logs can remain fairly secure (a little less secure than not exposing anything at all)
    * pro: gets us (Suffolk) out of the way, and gives developers more independence when using us
    * con: more exposure security-wise, not the only work to be done (need a DA wrapper to view the logs likely)
2. manually, only admins can do it
    * pro: simple, what we are already doing
    * pro: the most secure option: we know exactly who has the log data, and what data they have (i.e. we have to directly send it to them)
    * con: really slows down development and improvement speed for developers, not sustainable to have us handing out
      logs to everyone individually

### Decision

Went with 1, an API endpoint. Will have to test more of the download API, and think through things to make them secure.
TODO:
* [ ] hammer away at the security for a bit
* [ ] add logs when things are downloaded, so we know when they are, and by whom (as much as we can)

## How long to save the info?

### Considered alternatives for saving length

1. indefinitely
    * pro: easy
    * con: risky, logs will have less PII, but will remain to have at least some
2. rolling over, like a log
    * pro: don't have to worry about disk usage in the long run, esp with higher usage
    * con: people who have higher usage will have shorter windows to dig through logs and
      find details on their bugs
3. time based
    * pro: fixed amount of time to go through logs and find bugs
    * con: probably the most difficult to implement technically of the 3 options here

### Decision

Currently have 1 implemented, but 3 is the best option. Will take some time to get to however.
* [ ] change the ServerSpecificAppender.java to rollover based on time. Logback [has an example appender](https://logback.qos.ch/manual/appenders.html) with time based rolling that we should copy from (have already tried inheriting from logback classes, unfortunately it doesn't seem to work).
