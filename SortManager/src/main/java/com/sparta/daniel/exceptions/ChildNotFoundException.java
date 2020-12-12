package com.sparta.daniel.exceptions;

public class ChildNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "No child found";
    }



}
