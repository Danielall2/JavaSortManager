package com.sparta.daniel.arraymanager;

import com.sparta.daniel.interaction.ConsoleInteraction;
import com.sparta.daniel.tools.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ArrayCreator {

    private final static int SIZELIMIT = 10_000;
    private static int lowerLimit = -100;
    private static int upperLimit = 100;
    static Logger logger = LogManager.getLogger(ArrayCreator.class);

    public static int getSIZELIMIT() {
        return SIZELIMIT;
    }


    public static int getLowerLimit() {
        return lowerLimit;
    }

    public static void setLowerLimit(int lowerLimit) {
        ArrayCreator.lowerLimit = lowerLimit;
    }

    public static int getUpperLimit() {
        return upperLimit;
    }

    public static void setUpperLimit(int upperLimit) {
        ArrayCreator.upperLimit = upperLimit;
    }

    public static int[] createRandomArray(int size, int lowerLimit, int upperLimit) {
        logger.error("If a double is entered to create an Array the program will stop");
        while (size > SIZELIMIT) {
            size = ConsoleInteraction.sizeLimitExceeded();

        }

        int[] randomArray = new int[size];
        Random random = new Random();

        for (int index = 0 ; index < size ; index++) {
            randomArray[index] = random.nextInt(upperLimit-lowerLimit) + lowerLimit;
        }

        return randomArray;
    }

    public static int[] createRandomArray() {
        int size;
        if (ConsoleInteraction.chooseArraySizeConfirmation().equals("y")) {
            size = ConsoleInteraction.chooseArraySize();
        }
        else {
            Printer.printMessage("");
            Printer.printMessage("Default Array Size of 10 has been used");
            size = 10;
        }

        return createRandomArray(size, getLowerLimit(), getUpperLimit());
    }




}
