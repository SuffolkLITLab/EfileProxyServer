# Use a Platform and Database as Services to Improve Operations

## Context

The existing system is deployed to Lightsail. Both the Java application and Postgres database are Dockerized and run within the Lightsail VPS. Many tasks require connecting to the running server and executing commands in the shell.

**User Story:**
As a Suffolk LIT Lab operator, I want to improve the ease of operations in these key areas:
* Data: recover from a possible data loss by restoring a previous version of the database or rolling back the database
* App Stability: restart the app in case it crashes or becomes unavailable
* Monitoring / Alerting: monitor the app and be alerted when there are issues with the API being available

Ideally, this will lower the barrier to entry for others to run their own EfileProxyServer instances.

## Decision

Use the combination of a Platform-as-a-Service (PaaS) with a Database-as-a-Service (DBaaS), specifically Fly.io and Supabase. Both offerings have dashboards with good usability. You can view logs and key metrics (memory usage, CPU, error counts, query performance) through the web interface. You can also perform common operational tasks such as restarting a machine and restoring the database. Some key tasks, such as the daily database backup and security updates to the operating system, are handled automatically by the platform, reducing the manual operational load.

## Alternatives Considered

1. Scripting out common operations and using cron jobs with the existing Lightsail setup
   * Pros
     * Builds on existing familiarity with the system
     * Smaller delta between the new process and the existing process
   * Cons
     * Would have to still handle many operational tasks manually
     * More development work per operational task
2. Postgres database replication
   * Pros
     * Adds resiliency with minimal modification
   * Cons
     * Only addresses the Data bullet point
     * Would still require a decision on the replica database
3. Using a different PaaS such as Heroku
   * Pros
     * Ease-of-use and more features out-of-the-box
   * Cons
     * Expensive if the application requires more than 2GB of memory
     * Less optimized for Docker applications than Fly.io
4. Using a different Database-as-a-Service (DBaaS) such as Heroku Postgres, AWS Aurora, or Neon
   * Pros
      * Similar operational characteristics
   * Cons
     * Supabase has the best combination of ease of use, pricing, and track record. All the other alternatives are beaten in one or more of those aspects in comparison  
   * Notes
     * This is an easy decision to change our minds on in the future, as any Postgres-compatible database can be swapped in by changing the POSTGRES_* variables in the .env and the data is quite portable with a variety of pg_dump/export/replication options supported by all the DBaaS options.