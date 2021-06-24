package edu.suffolk.assemblyline.efspserver.services;

public enum ExtractError {
  MalformedInterview, /// For when the json is somehow not well formed, or just plain wrong
  MissingRequired /// For when the json doesn't have a member that is needed, like "users"
}
