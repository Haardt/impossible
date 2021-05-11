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
        // Not supported in java 16
        // return switch (this) {
//            case User u -> fn.apply(u.contacts());
//            case LightUser u -> fn.apply(u.contacts());
//            case SuperUser u -> fn.apply(u.contacts());
//            case Guest g -> Optional.empty();
//        };
        if (this instanceof User u) {
            return u.contacts();
        } else if (this instanceof LightUser u) {
            return u.contacts();
        } else if (this instanceof SuperUser u) {
            return u.contacts();
        } else if (this instanceof Guest u) {
            return List.of();
        } else {
            return List.of();
        }
    }

    default <T> Optional<T> mapProfile(Function<Profile, T> fn) {
        if (this instanceof User u) {
            return Optional.ofNullable(fn.apply(u.profile()));
        } else if (this instanceof LightUser u) {
            return Optional.ofNullable(fn.apply(u.profile()));
        } else if (this instanceof SuperUser u) {
            return Optional.ofNullable(fn.apply(u.profile()));
        } else if (this instanceof Guest u) {
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }
}
