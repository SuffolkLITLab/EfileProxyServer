# Java JSON Library Choice

Author: Bryce Willey

We need some library that will help us parse JSON in Java, as
docassemble communicates it's current state through JSON.

Not considered: Rolling our own JSON parser, because that's silly

## Considered Alternatives

* GSON
* Jackson JSON 

## Decision Outcome

* Jackson JSON 
* The primary desire was to reduce the number of libraries we were using: no real need for JSON
* The code did need to be refactored to use proper deserializers and serializers anyway, and
  making that jump as well as the switch from GSON to Jackson was really easy  

## Pros and Cons of the Alternatives <!-- optional -->

### GSON 

* `+` I (Brycew) have used it before 
* `+` (At some point) most of the code was already using this
* `-` The existing code is a bit hacky, and not ammenable to refactoring or updates

### Jackson 

* `+` Slightly faster than GSON (from what I've seen, don't have the links any more) 
* `+` Already used in CXF/Spring behind the scenes when reading server queries to endpoints

