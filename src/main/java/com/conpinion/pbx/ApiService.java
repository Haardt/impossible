package com.conpinion.pbx;

import com.conpinion.user.SuperUser;

public class ApiService {
    public void enableApiService(SuperUser user) {
        System.out.println("API enabled by: " + user.basicClaims().lastName());
    }
}
