package com.sparta.daniel.sorter;

import com.sparta.daniel.binarytree.BinaryTree;
import com.sparta.daniel.tools.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

// Use this class to initialise the Binary Tree and then use this in Starter
public class BinaryTreeSort implements Sorter{

    static Logger logger = LogManager.getLogger(BinaryTreeSort.class);

    @Override
    public int[] sortArray(int[] arrayToSort) {

//        logger.debug("Binary Tree Sort has been used");

        if (arrayToSort.length == 0) {
            return arrayToSort;
        }

        BinaryTree binaryTree = new BinaryTree(arrayToSort[0]);

        for (int index = 1 ; index < arrayToSort.length ; index++) {
            binaryTree.addElement(arrayToSort[index]);
        }

        return binaryTree.getSortedTreeAsc();
    }

}
