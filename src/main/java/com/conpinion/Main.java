package com.conpinion;

import com.conpinion.db.UserRepository;
import com.conpinion.pbx.ApiService;
import com.conpinion.pbx.PbxService;
import com.conpinion.pbx.RestService;
import com.conpinion.user.*;
import com.conpinion.util.Result;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var userRepository = new UserRepository();
        var userService = new UserService(userRepository);
        var restService = new RestService(userService);
        var apiService = new ApiService();
        var pbxService = new PbxService();

        User user = userService.getUsers().get(0);
        Guest guest = userService.getGuestUsers().get(0);

        pbxService.callNumber(user, "1234");
//        pbxService.callNumber(guest, "1234");

        restService.getAllUsers().forEach(userResult ->
                System.out.println(userResult));

//        pbxService.callNumber(guest, "1234");

        var result = Result.<String, String>right("TestData");
        Function<String, String> splitter = (String string) ->
                String.join("-", string.split("(?<=.)(?=(\\p{Upper}))"));

        result
                .map(splitter)
                .map(String::toUpperCase)
                .then(value -> System.out.println("Right: " + value))
                .orError(e -> System.out.println("Left:" + e));
    }
}

