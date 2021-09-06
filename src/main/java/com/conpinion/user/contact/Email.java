package com.conpinion.user.contact;

public sealed interface Email extends Contact {
    String value();
}

final record EmailImpl(String value) implements Email {
}

//public final class Email implements Contact{
//    private String value;
//
//    Email(String value) {
//        this.value = value;
//    }
//
//    public static Optional<Email> createEmail(String value) {
//        if (value == null || value.contains("@")) {
//            return Optional.empty();
//        }
//        return Optional.of(new Email(value));
//    }
//
//    public String value() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Email email = (Email) o;
//        return Objects.equals(value, email.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(value);
//    }
//}
