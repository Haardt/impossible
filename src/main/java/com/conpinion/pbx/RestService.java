package com.conpinion.pbx;

import com.conpinion.user.*;
import com.conpinion.user.contact.Contact;
import com.conpinion.user.contact.Email;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentNavigableMap;


public class RestService {
    private final UserService userService;

    public RestService(UserService userService) {
        this.userService = userService;
    }

    public List<String> getAllUsers() {

        record UserDto(String name, String email, String profileMode) {
        }

        return userService.getAllUsers()
                .stream()
                .map(userType ->
                        new UserDto(userType.basicClaims().firstName(),
                                Contact.getFirstEmail(userType.contacts())
                                        .map(Email::value)
                                        .orElse("<not provided>"),
                                userType.mapProfile(Profile::mode)
                                        .orElse(UiMode.LIGHT).name()))
                .map(dto -> """
                        User: %s
                        Email: %s
                        UI-Mode: %s
                        """.formatted(
                        dto.name,
                        dto.email,
                        dto.profileMode)).toList();
    }

    public int post(String firstName, String lastName, String email) {
        record RequestValidator(String error, Optional optional) {
        }

        var val = List.of(
                new RequestValidator("firstName", Optional.ofNullable(firstName)),
                new RequestValidator("lastName", Optional.ofNullable(lastName)),
                new RequestValidator("email", Contact.createEmail(email)));

        var errors = val.stream().map(x ->
                switch (x.optional.orElse(null)) {
                    case null -> Optional.of(x.error);
                    default -> Optional.<String>empty();
                }).filter(Optional::isPresent).map(Optional::get).toList();
        System.out.println("Errors" + errors);

        new LightUser(new BasicClaims(firstName, lastName),
                List.of(Contact.createEmail(email).get())
                , new Profile(UiMode.DARK)

        );
        return 0;
    }
}
