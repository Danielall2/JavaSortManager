package com.sparta.daniel.sorter;

import com.sparta.daniel.tools.Swap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The code for implementing the quicksort has been taken from : https://careerkarma.com/blog/java-quicksort/
public class QuickSort implements Sorter {

    static Logger logger = LogManager.getLogger(QuickSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {

//        logger.debug("Quick Sort has been used");

        quickSort(arrayToSort, 0, arrayToSort.length - 1);

        return arrayToSort;
    }

    public int prepare(int[] array, int low, int high) {
        int pivot = array[high];
        int item = low - 1;

        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                item++;
                Swap.swapArrayTwoNumbers(array,item,i);
            }
        }

        int swap = array[item + 1];
        array[item + 1] = array[high];
        array[high] = swap;
        return (item + 1);
    }

    void quickSort(int numbers[], int low, int high) {
        if (low < high) {
            int pivot = prepare(numbers, low, high);

            quickSort(numbers, low, pivot - 1);
            quickSort(numbers, pivot + 1, high);
        }
    }


}