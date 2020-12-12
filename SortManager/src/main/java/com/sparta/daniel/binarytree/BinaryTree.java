package com.sparta.daniel.binarytree;

import com.sparta.daniel.exceptions.ChildNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BinaryTree implements BinaryTreeInterface {
    private final Node rootNode;
    private int numberOfElements = 1;
    private int index;
    int[] sortedByAscending;
    int[] sortedByDescending;

    static Logger logger = LogManager.getLogger(BinaryTree.class);

    public BinaryTree(final int element) {
        rootNode = new Node(element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public void addElements(int[] elements) {
        for (int elementInArray : elements) {
            addElement(elementInArray);
        }
    }

    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    // Have implemented the same method as findNode but return true or false depending on if value exists
    @Override
    public boolean findElement(int value) {
        Node node = rootNode;

        while (node != null) {
            if (value == node.getValue()) {
                return true;
            }
            if (value < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return false;
    }

    @Override
    public int getLeftChild (int element) throws ChildNotFoundException {
        if (rootNode.isLeftChildEmpty()) {
            throw new ChildNotFoundException();
        }
        return rootNode.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException{
        if (rootNode.isRightChildEmpty()) {
            throw new ChildNotFoundException();
        }
        return rootNode.getRightChild().getValue();
    }

    // Below have used another method to implement the sort
    @Override
    public int[] getSortedTreeAsc() {
        index = 0;
        sortedByAscending = new int[numberOfElements];

        sortByAscending(rootNode);

        return sortedByAscending;

    }

    private void sortByAscending(Node node) {
        if (node == null) {
            return;
        }

        sortByAscending(node.getLeftChild());
        sortedByAscending[index] = node.getValue();
        index++;
        sortByAscending(node.getRightChild());

    }


    @Override
    public int[] getSortedTreeDesc() {
        index = 0;
        sortedByDescending = new int[numberOfElements];

        sortByDescending(rootNode);

        return sortedByDescending;
    }

    private void sortByDescending(Node node) {
        if (node == null) {
            return;
        }

        sortByDescending(node.getRightChild());
        sortedByDescending[index] = node.getValue();
        index++;
        sortByDescending(node.getLeftChild());


    }

    // Removed block that deals with duplicate values as want this included in the sorted array
    private void addNodeToTree(Node node, int element) {
        //logger.debug("Building Binary Tree");

        if (element < node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberOfElements++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        }

        else if (element >= node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
                numberOfElements++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    public Node findNode(int element) {
        Node node = rootNode;
        while (node != null) {
            if (element == node.getValue()) {
                return node;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }


}
