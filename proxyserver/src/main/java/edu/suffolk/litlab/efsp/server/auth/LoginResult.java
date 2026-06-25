package edu.suffolk.litlab.efsp.server.auth;

import java.util.Map;
import java.util.Optional;

public record LoginResult(Map<String, String> tokens, Optional<String> expirationDateTime) {}
