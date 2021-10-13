package main.java.by.chuprys.itcompany.exeption;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Resourse implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(Resourse.class);

    public void connect(){
        LOGGER.debug("Connected");
    }

    @Override
    public void close()  {
        LOGGER.debug("Connection closed");

    }
}
