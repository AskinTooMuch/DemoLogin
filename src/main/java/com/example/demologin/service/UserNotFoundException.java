package com.example.demologin.service;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String s) {
        super(s);
    }
}
