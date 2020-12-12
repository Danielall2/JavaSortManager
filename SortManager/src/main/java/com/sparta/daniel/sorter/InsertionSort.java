package com.sparta.daniel.sorter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSort implements Sorter {

    static Logger logger = LogManager.getLogger(InsertionSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {

//        logger.debug("Insertion Sort has been used");

        // Define length of array
        int arrayLength = arrayToSort.length;

        // Loop through each number apart from index 0
        for (int i = 1 ; i < arrayLength ; i++) {

            // Assign the value for comparison and to have the variable assigned
            int compareTo = arrayToSort[i];

            // Assign a a value to keep track of index while moving
            int j = i - 1;

            // While there are numbers still behind and the number behind is greater than the number in front
            while (j >= 0 && arrayToSort[j] > compareTo) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }

            // This is here so that the CompareTo value is placed in the correct index
            arrayToSort[j + 1] = compareTo;
        }

        return arrayToSort;
    }
}
