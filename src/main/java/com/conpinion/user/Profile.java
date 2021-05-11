package com.conpinion.user;

import java.util.Objects;

public record Profile(UiMode mode) {
    public Profile {
        Objects.requireNonNull(mode);
    }
}
