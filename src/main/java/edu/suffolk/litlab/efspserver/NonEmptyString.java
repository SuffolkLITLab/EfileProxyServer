package edu.suffolk.litlab.efspserver;

import java.util.Optional;

public class NonEmptyString {
    private final String data;

    public static Optional<NonEmptyString> create(String data) {
        if (data == null || data.isBlank()) {
            return Optional.empty();
        } else {
            return Optional.of(new NonEmptyString(data));
        }
    }

    private NonEmptyString(String data) {
        this.data = data;
    }

    public String get() {
        return data;
    }
}
