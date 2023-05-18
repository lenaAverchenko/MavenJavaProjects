package org.telran.prof.com.homework23;

public class IncorrectIbanNumberException extends RuntimeException {

    String number;

    public IncorrectIbanNumberException(String message, String number) {
        super(message);
        this.number = number;
    }
}
