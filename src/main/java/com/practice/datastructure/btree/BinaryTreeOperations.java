package com.practice.datastructure.btree;

class Node{
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

}

public class BinaryTreeOperations {
    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public static void main(String[] args) {
        BinaryTreeOperations bto =  new BinaryTreeOperations();
        bto.add(5);
        bto.add(4);
        bto.add(8);
        bto.add(2);
        bto.add(9);
        bto.add(45);
        bto.add(51);

        System.out.println(bto);

    }

}
