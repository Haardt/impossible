package com.conpinion.user;

import com.conpinion.user.contact.Contact;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final record LightUser(@NotNull BasicClaims basicClaims, List<Contact> contacts, Profile profile) implements UserType {
    public LightUser {
        Objects.requireNonNull(basicClaims);
        Objects.requireNonNull(profile);
        Objects.requireNonNull(contacts);

        if (contacts.size() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
