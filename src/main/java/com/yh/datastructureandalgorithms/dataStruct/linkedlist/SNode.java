package com.yh.datastructureandalgorithms.dataStruct.linkedlist;

public class SNode<T> {
    private T element;
    private SNode next;

    public SNode(T element) {
        this.element = element;
    }

    public SNode(T element, SNode next) {
        this.element = element;
        this.next = next;
    }

    public SNode<T> next(SNode<T> next) {
        this.next = next;
        return next;
    }

    public SNode() {
        this.next = null;
    }


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SNode getNext() {
        return next;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}
