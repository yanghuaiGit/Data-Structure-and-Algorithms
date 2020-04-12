package com.yh.datastructureandalgorithms.dataStruct.heap;

/**
 * 堆
 */
public class Heap<T extends Comparable<? super T>> {
    /**
     * 数组，从下标为1开始存储数据
     */
    private T[] array;
    private int currentSize;

    public Heap(T[] array) {
        currentSize = array.length;
    }

    public void insert(T data) {
        if (currentSize == array.length - 1) {
            //堆满了 do nothing
            return;
        }
        ++currentSize;
    }


}
