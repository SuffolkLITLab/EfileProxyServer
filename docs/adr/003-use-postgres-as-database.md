# Choice of Database for the Project

2021-04-23

TODO(brycew): document this decision as it was made.

Mostly in conversations with Quinten, a little bit of research as it was chosen.

> [4/23, 12:00 PM] Bryce Willey
>    So, I'm working with the Tyler Court codes, and it's definitely a bit more complicated than I was expecting, and I don't think I'll be able to make it maintainable as an in-java/in-memory "database", and I think I'm gonna try to switch it to an actual database. Do you have any advice about which DB might be a good choice? It's just going to contain code information (there's about 5 tables at the system level, and then there about 20 more tables that each court has it's own configuration for. I don't have a lot of admin knowledge of things like MySQL vs PosgreSQL vs MariaDB, or anything like that, and was gonna just go with PostgreSQL unless you have any good suggestions or things to look into. 
> [4/23, 12:01 PM] Quinten Steenhuis
>    How large is the database going to be?
> [4/23, 12:02 PM] Quinten Steenhuis
>   overall, MariaDB is just the "freer" version of MySQL. I used to just use MySQL before Postgres came along. People used to still use MySQL for performance reasons and Postgres was the "safer/more robust" choice. Nowadays I think Postgres has caught up in performance, so it's probably the best all around option
> [4/23, 12:07 PM] Quinten Steenhuis
>   big advice would be to make use of ORM if you can
> [4/23, 12:11 PM] Bryce Willey
>    Not sure, not extremely big. Some envelope calculations are that the zip files containing the system codes total about 200kb, and the court codes for one court type are a total of 650kb, so safe to say it'll be less than 200MB, unless the same DB is serving multiple states
> (1 liked)​[4/23, 12:12 PM] Quinten Steenhuis
>    Performance won't be very relevant in that case
> (1 liked)​[4/23, 12:14 PM] Bryce Willey
>    And that's fair. Not sure if I can use ORM since there aren't existing objects for the codes, but the codes are already laid out in a table-like way. But I'm also not familiar with it, I'll look into it a bit more. 

[4/23, 12:14 PM] Bryce Willey
    And that's good, it sounds like Postgres would be a good choice. Thanks! 
> [4/23, 12:15 PM] Quinten Steenhuis
    if you don't have an ORM model in mind, I guess it's more helpful to suggest using some kind of parameterized queries for safety reasons. it is a bit of overhead but I think it's worth the effort
> [4/23, 12:16 PM] Quinten Steenhuis
    (in some cases it can make things simpler--but the downside being that you have to learn two APIs--the framework and the Postgres SQL syntax
> [4/23, 12:17 PM] Quinten Steenhuis
    I think the one that Jonathan uses is very popular-sqlalchemy
    oh wait, sorry, that's for Python! I don't know about Java equivalents
> [4/23, 12:21 PM] Bryce Willey
>   I feel like I've worked most with parameterized queries before, but I've mostly just never had time to explore the options. I'll look into it, ORM might be a good fit with Java, even if I have to make the ORM model manually. 
> [4/28, 11:11 PM] Bryce Willey
    So it looks like the one court I had calculated with wasn't very representative, the whole database is already at 600MB, and I think I'm only about 1/2 way through downloading it. 




*[context and problem statement]*
*[decision drivers | forces]* <!-- optional -->

## Considered Alternatives

* *[alternative 1]*
* *[alternative 2]*
* *[alternative 3]*
* *[...]* <!-- numbers of alternatives can vary -->

## Decision Outcome

* Chosen Alternative: *[alternative 1]*
* *[justification. e.g., only alternative, which meets KO criterion decision driver | which resolves force force | ... | comes out best (see below)]*
* *[consequences. e.g., negative impact on quality attribute, follow-up decisions required, ...]* <!-- optional -->

## Pros and Cons of the Alternatives <!-- optional -->

### *[alternative 1]*

* `+` *[argument 1 pro]*
* `+` *[argument 2 pro]*
* `-` *[argument 1 con]*
* *[...]* <!-- numbers of pros and cons can vary -->

### *[alternative 2]*

* `+` *[argument 1 pro]*
* `+` *[argument 2 pro]*
* `-` *[argument 1 con]*
* *[...]* <!-- numbers of pros and cons can vary -->

### *[alternative 3]*

* `+` *[argument 1 pro]*
* `+` *[argument 2 pro]*
* `-` *[argument 1 con]*
* *[...]* <!-- numbers of pros and cons can vary -->

