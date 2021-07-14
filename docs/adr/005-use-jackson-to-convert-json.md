# Java JSON Library Choice

TODO(brycew): document this choice as it was handled

Was primarily GSON, since I had worked with it before, and it's pretty simple.
However, it's slower, the jump to figuring out actual deserialization and serialization
is just as hard for GSON and jackson, jackson is faster, and jackson was already included,
as javax-RS already requires it.
