package com.sparta.daniel.interaction;


import com.sparta.daniel.arraymanager.ArrayCreator;
import com.sparta.daniel.sortmanager.Factory;
import com.sparta.daniel.start.TimeChecker;
import com.sparta.daniel.tools.Printer;


public class ConsoleInteraction {

    public static Integer consoleChooseSorter() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Printer.printMessage("");
        Printer.printMessage("");
        Printer.printMessage("Possible Sorting Algorithms : ");
        Printer.printMessage("1. Bubble Sort");
        Printer.printMessage("2. Insertion Sort");
        Printer.printMessage("3. Merge Sort");
        Printer.printMessage("4. Quick Sort");
        Printer.printMessage("5. Selection Sort");
        Printer.printMessage("6. Binary Tree Sort");
        Printer.printMessage("");
        Printer.printMessage("Please enter a number between 1 and 6 for the associated sort method: ");
        int number = scanner.nextInt();
        Printer.printMessage("The Method chosen is " + Factory.ReturnSortType(number));

        return number;
    }

    public static int[] initialiseSorter(int number, int[] arrayToSort) {
        return Factory.SortFactory(number, arrayToSort);
    }

    public static String chooseArraySizeConfirmation () {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Printer.printMessage("");
        Printer.printMessage("Do you want to choose the array size ? (y/n)");
        Printer.printMessage("Please answer with either: y or n");
        return scanner.nextLine();
    }

    public static int chooseArraySize() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Printer.printMessage("");
        Printer.printMessage("Please state size of array");
        Printer.printMessage("Size must be an integer between 0 and 10000");
        return scanner.nextInt();
    }

    public static void getTimeDifference() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Printer.printMessage("");
        Printer.printMessage("Would you like to perform a timed test of each sort? (y/n)");
        Printer.printMessage("Please answer with either: y or n");
        if (scanner.nextLine().equals("y")) {
            TimeChecker.performanceTester();
        }
    }

    public static int sizeLimitExceeded() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Printer.printMessage("");
        Printer.printMessage("Size requested exceeds maximum size of " + ArrayCreator.getSIZELIMIT());
        Printer.printMessage("Please choose a number below this : ");
        return scanner.nextInt();
    }
}
