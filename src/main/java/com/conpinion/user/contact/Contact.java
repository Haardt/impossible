package com.conpinion.user.contact;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public sealed interface Contact permits Address, Email, PhoneNumber {
    static Stream<Email> getEmails(@NotNull Contact contact) {
        return Stream.of(contact)
                .filter(Email.class::isInstance)
                .map(Email.class::cast);
    }

    static Optional<Email> getFirstEmail(List<Contact> contacts) {
        return contacts.stream()
                .flatMap(Contact::getEmails)
                .findFirst();
    }

    static Optional<Email> createEmail(String email) {
        if (email.contains("@")) {
            return Optional.of(new EmailImpl(email));
        }
        return Optional.empty();
    }
}
