package com.conpinion.user;

import java.util.Objects;

public final record Guest(BasicClaims basicClaims, Profile profile) implements UserType {
    public Guest {
        Objects.requireNonNull(basicClaims);
        Objects.requireNonNull(profile);
    }
}
