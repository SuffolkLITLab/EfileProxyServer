# Choice of Database for the Project

Author: Bryce Willey

Date: 2021-04-23

Status: Implemented

Mostly in conversations with Quinten, a little bit of research as it was chosen.

Tyler Technologies (specifically Tyler Technologies, not the ECF v4.0 standard) has a system of
Court codes, which are genericode XML files per court (and a few court-wide ones) that
allow courts flexibility in what sorts of fields they expect in filings. It's complicated,
to the point that the most maintainable and simple implementation of these codes in Java would
be in an actual SQL database, as opposed to an Java data structures in memory and serialized /
deserialized directly. Thus, we need to choose a specific SQL database implementation that
would work the best for our purposes.

There are about 20 tables that need to be handled, most of them being very small, but
a few of the tables are rather large (500MB to 1 GB), so something like SQLlite is
not considered for performance reasons.

## Considered Alternatives

* PostgreSQL
* MySQL
* MariaDB

## Decision Outcome

* Postgres!
* Even at 1GB, the tables aren't too big, so performance isn't a huge issue in this case.
* PostgreSQL is the simplest, and is the same SQL DB used by Docassemble, so it's one less library
  that we have to learn

Follow up needed (another ADR? no work is started as of 7/19), on whether we want to switch to ORM for
maintainability: so far, the few queries so far have been handwritten SQL queries.

## Pros and Cons of the Alternatives <!-- optional -->

### PostgreSQL

* `+` Generally considered the "safer, more robust" choice
* `+` Also used by Docassemble
* `-` Historically has been slower than MySQL, but might not be true any more

### MySQL

* `+` Probably the most used SQL DB

### MariaDB

* `+` The "freer" version of MySQL

