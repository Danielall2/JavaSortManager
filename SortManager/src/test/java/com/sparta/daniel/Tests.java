package com.sparta.daniel;

import com.sparta.daniel.arraymanager.ArrayCreator;
import com.sparta.daniel.sortmanager.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Tests {
    private static final int NUMBEROFSORTERS = 6;

    @Test
    void doesSortGiveRightLength() {
        final int[] testArray = new int[]{4,2,7,9,10};
        for (int sorter = 1; sorter <= NUMBEROFSORTERS; sorter++) {
            // May produce null pointer exception warning is acceptable. It is a possibility if the wrong number is designated
            Assertions.assertEquals(5, Factory.SortFactory(sorter, testArray).length);
        }
    }

    @Test
    void emptyArrayReturnsEmptyArray() {
        int[] emptyArray = new int[]{};
        for (int sorter = 1; sorter <= NUMBEROFSORTERS; sorter++) {
            Assertions.assertEquals(emptyArray, Factory.SortFactory(sorter, emptyArray));
        }
    }

    // I want to test console interaction but that must be done manually rather than through automation I think


    // Here I would like to test that the sorting methods function correctly but cannot return an Array type using in-built sort method
    // I have done a similar test below but using each of my sorter methods, rather than a guaranteed inbuilt sort method.
//    @Test
//    void isTheArraySorted() {
//        final int[] testArray = new int[]{4,7,9,2,3,2,2,2,6,7,8,5};
//        for (int sorter = 1 ; sorter <= numberOfSorters ; sorter++) {
//            Assertions.assertEquals(Arrays.toString(Arrays.sort(testArray)), Arrays.toString(Factory.SortFactory(sorter, testArray)));
//        }
//    }

    @Test
    void doSortMethodsProduceSameResult() {
        final int[] testArray = new int[]{4,7,9,2,3,2,2,2,6,7,8,5};
        // Noting that middle condition does not have <=, instead it uses <
        for (int sorter = 1; sorter < NUMBEROFSORTERS; sorter++) {
            Assertions.assertEquals(Arrays.toString(Factory.SortFactory(sorter + 1, testArray)), Arrays.toString(Factory.SortFactory(sorter, testArray)));
        }
    }

    @Test
    void factoryReturnsCorrectSort() {
        Assertions.assertEquals("Quick Sort", Factory.ReturnSortType(4));
    }

    @Test
    void createRandomArrayOfCorrectSize() {
        Assertions.assertEquals(5, ArrayCreator.createRandomArray(5,-100,100).length);
    }

    @Test
    void maximumSizeLimitIsAvailable() {
        Assertions.assertEquals(ArrayCreator.getSIZELIMIT(), ArrayCreator.createRandomArray(ArrayCreator.getSIZELIMIT(), -100, 100).length);
    }



}
