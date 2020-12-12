package com.sparta.daniel.sorter;

import com.sparta.daniel.tools.Printer;
import com.sparta.daniel.tools.Swap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class BubbleSort implements Sorter {

    static Logger logger = LogManager.getLogger(BubbleSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {


        int arrayLength = arrayToSort.length;

        for (int index = 0 ; index < arrayLength - 1 ; index++) {
            if(arrayToSort[index] > arrayToSort[index + 1]) {
                Swap.swapArrayTwoNumbers(arrayToSort, index, index + 1);
            }
        }

        for (int indexCheck = 0 ; indexCheck < arrayLength - 1 ; indexCheck++) {
            if (arrayToSort[indexCheck] > arrayToSort[indexCheck + 1]){
                sortArray(arrayToSort);
            }

        }
//        logger.debug("Bubble Sort has been used");

        return arrayToSort;
    }

}
