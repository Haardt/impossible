package com.conpinion.pbx;

import com.conpinion.user.UserService;
import com.conpinion.user.contact.Contact;
import com.conpinion.user.contact.Email;

import java.util.List;


public class RestService {
    private final UserService userService;

    public RestService(UserService userService) {
        this.userService = userService;
    }

    public List<String> getAllUsers() {

        record UserDto(String name, String email) {
        }

        return userService.getAllUsers()
                .stream()
                .map(userType ->
                        new UserDto(userType.basicClaims().firstName(),
                                Contact.getFirstEmail(userType.contacts())
                                        .map(Email::value)
                                        .orElse("<not provided>")))
                .map(dto -> """
                        User: %s
                        Email: %s
                        """.formatted(dto.name, dto.email)).toList();

    }
}
