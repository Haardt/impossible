package com.conpinion.user;

import com.conpinion.user.contact.Contact;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public sealed interface UserType
        permits SuperUser, User, LightUser, Guest {

    BasicClaims basicClaims();

    default  List<Contact> contacts() {
         return switch (this) {
            case User u -> u.contacts();
            case LightUser u -> u.contacts();
            case SuperUser u -> u.contacts();
            case Guest g -> List.of();
        };
    }

    default <T> Optional<T> mapProfile(Function<Profile, T> fn) {
        return switch (this) {
            case User u -> Optional.ofNullable(fn.apply(u.profile()));
            case LightUser u -> Optional.ofNullable(fn.apply(u.profile()));
            case SuperUser u -> Optional.ofNullable(fn.apply(u.profile()));
            case Guest g -> Optional.empty();
        };
    }
}
