package com.sparta.daniel.start;

import com.sparta.daniel.interaction.ConsoleInteraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {

    static Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {

        logger.info("");
        logger.info("Beginning of Program");

        TimeChecker.sortWithTimeDifference();

        logger.info("If a performance test is requested another random array will be created");
        ConsoleInteraction.getTimeDifference();

        logger.info("End of Program");

    }
}
