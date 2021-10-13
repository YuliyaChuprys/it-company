package main.java.by.chuprys.itcompany.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidDocumentData extends  RuntimeException {

    public InvalidDocumentData(String message) {
        super(message);
    }

    public InvalidDocumentData(String message, Throwable cause) {
        super(message, cause);
    }
}
