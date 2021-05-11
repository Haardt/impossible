package com.conpinion.user.contact;

public final record PhoneNumber(String number) implements Contact {
    public PhoneNumber {
        assert (number != null && number.isBlank());
    }
}
