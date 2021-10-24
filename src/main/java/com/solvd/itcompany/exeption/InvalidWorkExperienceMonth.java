package com.solvd.itcompany.exeption;

public class InvalidWorkExperienceMonth extends Exception {

    public InvalidWorkExperienceMonth(String message) {
        super(message);
    }

    public InvalidWorkExperienceMonth(String message, Throwable cause) {
        super(message, cause);
    }
}
