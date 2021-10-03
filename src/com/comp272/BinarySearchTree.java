package com.comp272;
import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    private BinaryTree<E> gogo;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public BinarySearchTree(E val) {
        gogo = new BinaryTree(val);

    }

    // returns true if BST has val else false.
    public boolean contains(E val) {
        Node<E> current = gogo.root;
        while (current != null) {
            if (current.getInfo().compareTo(val) != 0) {
                if (val.compareTo(current.getInfo()) < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            if (current.getInfo().compareTo(val) == 0) {
                return true;
            }

        }
        if (current == null) {
            return false;
        }
        return false;
    }

    // inserts val at the right place satisfying search tree properties, should handle if the tree is empty
// if value is already there then donâ€™t insert it again
    public void insert(E val) {
        BinaryTree<E> gogot = new BinaryTree<E>(val);
        Node<E> curr = gogot.root;
        Node<E> pcurr = null;
        if (curr == null) {
            gogot = new BinaryTree<E>(val);
        } else if (val.compareTo(curr.info) < 0) {
            gogot.addLeft(curr.left, val);
        } else if (val.compareTo(curr.info) > 0) {
            gogot.addRight(curr.right, val);
        } else {
            return;
        }
    }

    // returns the minimum value stored in the tree
    public E findMin() {
        BinaryTree<E> trav = gogo;
        Node<E> tip = trav.root;

        while (tip.getLeft() != null) {
            tip = tip.getLeft();
        }

        return tip.getInfo();
    }


    // returns the maximum value stored in the tree
    public E findMax() {
        BinaryTree<E> gothrough = gogo;
        Node<E> top = gothrough.root;
        while (top.getRight() != null) {
            top = top.getRight();
        }
        return top.getInfo();
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        bt.insert(5);
        bt.insert(10);
        bt.insert(3);
        bt.insert(20);
        bt.insert(8);
        bt.insert(4);
    }
}


