# Exposing Logs to API Users

**User Story:** We want to expose logs on this proxy server to developers and API users of the proxy.

This is necessary because the interview devs need this info (both internal logs that show what happens when they call the API, and the logs when Tyler calls us about their cases), not us as the proxy maintainers. But the proxy server can't automatically deliver things to DA servers for convenient viewing.

## Considered Alternative

### How to record the info

* Manually, through our own API
* Use MDC from slf4j, which lets us tag each log message with an entity (the server name, and eventually the specific interview session ID)

### Where to save the info

* In the logs, filtering back out when we want to see it
* in a separate external file (likely in a docker volume)

### How to retrieve the info

* with an API endpoint, with the server's API key as a required header or param
* ?

### How long to save the info?

* indefinitely
* rolling over, like a log
* time based


## Decision Outcome

## Pros and Cons of Alternatives