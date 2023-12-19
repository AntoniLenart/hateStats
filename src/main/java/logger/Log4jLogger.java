package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger {

    private static Logger logger = LogManager.getLogger(Log4jLogger.class);


    public static void main(String[] args) {

        System.out.println("Hello world!");
        logger.info("test");
    }
}
