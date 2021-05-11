package com.conpinion.user;

import com.conpinion.db.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserType> getAllUsers() {
        return userRepository.getUsers();
    }

    public List<User> getUsers() {
        return userRepository.getUsers().stream()
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .toList();
    }

    public List<LightUser> getLightUsers() {
        return userRepository.getUsers().stream()
                .filter(LightUser.class::isInstance)
                .map(LightUser.class::cast)
                .toList();
    }

    public List<Guest> getGuestUsers() {
        return userRepository.getUsers().stream()
                .filter(Guest.class::isInstance)
                .map(Guest.class::cast)
                .toList();
    }
}
