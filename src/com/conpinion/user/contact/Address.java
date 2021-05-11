package com.conpinion.user.contact;

public final record Address(String city) implements Contact {
    public Address {
        assert (city != null && city.isBlank());
    }
};
