package com.conpinion.user;

import com.conpinion.user.contact.Contact;

import java.util.List;
import java.util.Objects;

public final record User(
        BasicClaims basicClaims,
        List<Contact> contacts,
        Profile profile) implements UserType {

    public User {
        Objects.requireNonNull(basicClaims);
        Objects.requireNonNull(profile);
        Objects.requireNonNull(contacts);

        if (contacts.size() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
