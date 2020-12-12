package com.sparta.daniel.start;

import com.sparta.daniel.arraymanager.ArrayCreator;
import com.sparta.daniel.interaction.ConsoleInteraction;
import com.sparta.daniel.sortmanager.Factory;
import com.sparta.daniel.tools.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TimeChecker {

    static Logger logger = LogManager.getLogger(TimeChecker.class);

    public static void sortWithTimeDifference() {

        int sorter = ConsoleInteraction.consoleChooseSorter();

        int[] array = ArrayCreator.createRandomArray();

        Printer.printMessage("");
        long start = System.nanoTime();
        Printer.printMessage("Sorted Array : " + Arrays.toString(ConsoleInteraction.initialiseSorter(sorter, array)));
        long finish = System.nanoTime();
        Printer.printMessage("Time taken to sort : " + (finish - start) + " " + "nanoseconds");

    }


    public static void performanceTester() {
        // I am slightly concerned about using final here.
        // Potential to prevent methods from altering the array but hopefully that is not the case.
        logger.warn("Random Array created as final.");
        logger.warn("Potential for issues within sort methods");
        final int[] testArray = ArrayCreator.createRandomArray();
        for (int sortNumber = 1 ; sortNumber <= 6 ; sortNumber++) {
            Printer.printMessage("");
            Printer.printMessage(Factory.ReturnSortType(sortNumber));
            long start = System.nanoTime();
            Printer.printMessage("Sorted Array : " + Arrays.toString(ConsoleInteraction.initialiseSorter(sortNumber, testArray)));
            // Want to include a logger here for testArray to make sure it doesn't change (immutable for next loop)
            long finish = System.nanoTime();
            Printer.printMessage("Time taken : " + (finish - start) + " " + "nanoseconds");
        }
    }
}
