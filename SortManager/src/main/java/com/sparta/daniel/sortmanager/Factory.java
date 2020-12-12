package com.sparta.daniel.sortmanager;

import com.sparta.daniel.sorter.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factory {

    static Logger logger = LogManager.getLogger(Factory.class);

    public static int[] SortFactory(int sorter, int[] arrayToSort) {
        logger.info("Sort Factory has been used");
        switch (sorter) {
            case 1:
                return new BubbleSort().sortArray(arrayToSort);
            case 2:
                return new InsertionSort().sortArray(arrayToSort);
            case 3:
                return new MergeSort().sortArray(arrayToSort);
            case 4:
                return new QuickSort().sortArray(arrayToSort);
            case 5:
                return new SelectionSort().sortArray(arrayToSort);
            case 6:
                return new BinaryTreeSort().sortArray(arrayToSort);
        }
        // If anymore sorter methods are created must add above
        return null;
    }

    public static String ReturnSortType(int sorter) {
        logger.info("Sort Type Factory has been used");
        switch (sorter) {
            case 1:
                return "BubbleSort";
            case 2:
                return "Insertion Sort";
            case 3:
                return "Merge Sort";
            case 4:
                return "Quick Sort";
            case 5:
                return "Selection Sort";
            case 6:
                return "Binary Tree Sort";
        }
        // If anymore sorter methods are created must add above
        return null;
    }


}
