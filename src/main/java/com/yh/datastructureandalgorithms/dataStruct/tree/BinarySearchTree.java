package com.yh.datastructureandalgorithms.dataStruct.tree;

import java.nio.BufferUnderflowException;
import java.util.Objects;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {


    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T fidMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).getElement();
    }

    public T fidMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).getElement();
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }


    private BinaryNode<T> remove(T x, BinaryNode<T> root) {
        return null;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> root) {
        return null;
    }


    public void printtree() {

    }


    private boolean contains(T x, BinaryNode<T> node) {
        return false;
    }

    private BinaryNode<T> findMin(BinaryNode node) {
        return null;
    }

    private BinaryNode<T> findMax(BinaryNode node) {
        return null;
    }

}
