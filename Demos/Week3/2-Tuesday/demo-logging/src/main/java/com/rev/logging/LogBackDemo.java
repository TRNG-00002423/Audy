package com.rev.logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackDemo {
    // 1. Get a Logger
    private static final Logger logger = LoggerFactory.getLogger(LogBackDemo.class);
    public static void main(String[] args) {
        // 2. Log a simple message
        logger.info("Apllication started....");

        try{
            int result = 100/0;
        } catch(ArithmeticException e){
            logger.error("An Arithmetic Exception Occured " + e);
        }
        finally{
            logger.info("Exception handled...");
        }
        logger.trace("Extemely Detaioled Info -- Severity - LOWest");
        logger.debug("Debugging Details --  LOW");
        logger.info("Apllication Exited ... -- MEDIUM");
        logger.warn("Warning Messages -- HIGH");
        logger.error("Error Messages -- HiGHEST");
    }
}