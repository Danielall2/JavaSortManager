package com.sparta.daniel.sorter;

import com.sparta.daniel.tools.Swap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionSort implements Sorter {

    static Logger logger = LogManager.getLogger(SelectionSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {

//        logger.debug("Selection Sort has been used");

        int arrayLength = arrayToSort.length;

        // First need to loop through all numbers in the array

        // Don't want to include the last number as by then should already be sorted through swap
        for ( int i = 0 ; i < arrayLength - 1 ; i++) {

            // Want to keep track of index without changing i in the for loop
            // Means I can swap using index and i at the end
            int index = i;

            // Need to include last element here to compare to
            // This loop is used to find the lowest number that is after the specified index
            for (int findLowestNumberIndex = i + 1; findLowestNumberIndex < arrayLength ; findLowestNumberIndex++) {
                if (arrayToSort[findLowestNumberIndex] < arrayToSort[index]){
                    index = findLowestNumberIndex;
                }
            }

            Swap.swapArrayTwoNumbers(arrayToSort, i, index);

        }
        return arrayToSort;
    }
}
