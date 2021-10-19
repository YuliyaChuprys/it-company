package main.java.by.chuprys.itcompany.exeption;

public class InvalidDocumentData extends RuntimeException {

    public InvalidDocumentData(String message) {
        super(message);
    }

    public InvalidDocumentData(String message, Throwable cause) {
        super(message, cause);
    }
}
