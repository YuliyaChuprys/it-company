package main.java.by.chuprys.itcompany.exeption;

public class InvalidWorkExperienceMonth extends Exception{

    public InvalidWorkExperienceMonth(String message) {
        super(message);
    }

    public InvalidWorkExperienceMonth(String message, Throwable cause) {
        super(message, cause);
    }
}
