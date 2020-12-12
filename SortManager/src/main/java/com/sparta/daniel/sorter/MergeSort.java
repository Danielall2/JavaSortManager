package com.sparta.daniel.sorter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSort implements Sorter {

    static Logger logger = LogManager.getLogger(MergeSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {
//        logger.debug("Merge Sort has been used");
        mergeSort(arrayToSort);
        return arrayToSort;
    }

    // Attempt at recursion taking inspiration from Binary Tree

    public static void mergeSort(int[] arrayToSort) {
        // If array is empty just return
        if(arrayToSort == null) {
            return;
        }

        if (arrayToSort.length > 1) {
            int midpoint = arrayToSort.length/2; // determines midpoint of array

            // Next two blocks of code focus on splitting the array into left and right segments
            int[] left = new int[midpoint];
            for (int i = 0 ; i < midpoint ; i++) {
                left[i] = arrayToSort[i];
            }

            int[] right = new int[arrayToSort.length - midpoint];
            for (int i = midpoint ; i < arrayToSort.length ; i++) {
                right[i-midpoint] = arrayToSort[i];
            }

            // Now introduce recursion on both left and right until the above condition (arrayToSort.length > 1)
            // is not met

            mergeSort(left);
            mergeSort(right);

            int firstCounter = 0;
            int secondCounter = 0;
            // Could introduce a third counter here but more variables so hopefully reducing space

            // Change to method for mergeArray
            while (firstCounter < left.length && secondCounter < right.length) {
                if (left[firstCounter] < right[secondCounter]) {
                    arrayToSort[firstCounter + secondCounter] = left[firstCounter];
                    firstCounter++;
                }
                else {
                    arrayToSort[firstCounter + secondCounter] = right[secondCounter];
                    secondCounter++;
                }
            }

            // Need to account for when left or right arrays are bigger and
            // when firstCounter < left.length or secondCounter < right.length
            // For example when one of the arrays has all the small numbers it will finish very quickly
            // leading to the above while loop stopping before finishing entering the numbers into
            // the array

            while (firstCounter < left.length) {
                arrayToSort[firstCounter + secondCounter] = left[firstCounter];
                firstCounter++;
            }

            while (secondCounter < right.length) {
                arrayToSort[firstCounter + secondCounter] = right[secondCounter];
                secondCounter++;
            }


        }

    }

}
