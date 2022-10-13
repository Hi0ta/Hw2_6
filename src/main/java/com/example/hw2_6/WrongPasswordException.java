package com.example.hw2_6;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
    }
    public WrongPasswordException(String message) {super(message);}
}
