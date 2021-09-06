package com.conpinion.db;

import com.conpinion.user.*;
import com.conpinion.user.contact.Contact;
import com.conpinion.user.contact.Email;
import com.conpinion.user.contact.PhoneNumber;

import java.util.List;

public class UserRepository {
    private List<UserType> users = List.of(
            new User(new BasicClaims("Alice", "Wunderland"),
                    List.of(
                            Contact.createEmail("alice@wunderland.de").get(),
                            new PhoneNumber("49")
                    ),
                    new Profile(UiMode.DARK)),
            new LightUser(new BasicClaims("Bob", "Baumeister"),
                    List.of(Contact.createEmail("bob@baumeister.de").get()),
                    new Profile(UiMode.LIGHT)),
            new SuperUser(new BasicClaims("Super", "Man"),
                    List.of(new PhoneNumber("007")),
                    new Profile(UiMode.DARK)),
            new Guest(new BasicClaims("Guest", "G"),
                    new Profile(UiMode.DARK))
    );

    public List<UserType> getUsers() {
        return users;
    }
}
