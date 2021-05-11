package com.conpinion.user;

import java.util.Objects;

public record BasicClaims(String firstName, String lastName) {
    public BasicClaims {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
    }
}
