package org.example;

public class FailedFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generatePassword() {
        return "wrong";
    }
}
