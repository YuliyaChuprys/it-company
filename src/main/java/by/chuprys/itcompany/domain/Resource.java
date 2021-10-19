package main.java.by.chuprys.itcompany.domain;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Resource implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(Resource.class);

    public void connect() {
        LOGGER.debug("Connected");
    }

    @Override
    public void close() {
        LOGGER.debug("Connection closed");

    }
}
