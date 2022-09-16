package com.conpinion.user.contact;

public sealed interface Email extends Contact {
    String value();
}

final record EmailImpl(String value) implements Email {

}