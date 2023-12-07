package com.yh.datastructureandalgorithms.dataStruct.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 最大堆
 * https://time.geekbang.org/column/article/69913
 */

public class MaxHeap<T extends Comparable<? super T>> {
    /**
     * 数组，从下标为1开始存储数据
     */
    private T[] array;
    private int currentSize;

    public MaxHeap(T[] array) {
        currentSize = array.length;
        buildHeap(array);
    }

    public void insert(T data) {
        if (currentSize == array.length - 1) {
            enlageArray(currentSize * 2 + 1);
        }
        int hole = ++currentSize;

        array[hole] = data;
        //自下往上进行堆化
        while (hole / 2 > 0 && array[hole].compareTo(array[hole / 2]) > 0) {
            swap(array, hole, hole / 2);
            hole = hole / 2;
        }
    }

    private void removeMax() {
        if (currentSize == 0) {
            return;
        }

        array[1] = array[currentSize];
        --currentSize;
        heapify(array, currentSize, 1);
    }


    private void swap(T[] array, int child, int parent) {
        T t = array[child];
        array[child] = array[parent];
        array[parent] = t;
    }

    //自上往下进行堆化
    //堆只是完全二叉树 不是搜索二叉树 左边节点小于右边节点 是没有这个限制的
    //因此每次循环，找到坐标为i的root节点的子节点中 大于root且是最大值 需要判断左节点 和 右节点
    private void heapify(T[] array, int currentSize, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= currentSize && array[i].compareTo(array[i * 2]) < 0) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= currentSize && array[maxPos].compareTo(array[i * 2 + 1]) < 0) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(array, i, maxPos);
            i = maxPos;
        }
    }

    @Override
    public String toString() {
        return "Heap{" +
                "array=" + Arrays.toString(array) +
                ", currentSize=" + currentSize +
                '}';
    }

    private void buildHeap(T[] items) {
        array = (T[]) new Comparable[currentSize * 2 + 1];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        for (int j = currentSize / 2; j > 0; j--) {
            heapify(array, currentSize, j);
        }

    }

    private void enlageArray(int size) {
        T[] newArray = (T[]) new Comparable[size];
        int i = 1;
        for (T item : array) {
            newArray[i++] = item;
        }
        this.array = newArray;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[9];
        integers[0] = 7;
        integers[1] = 5;
        integers[2] = 19;
        integers[3] = 8;
        integers[4] = 4;
        integers[5] = 1;
        integers[6] = 20;
        integers[7] = 13;
        integers[8] = 16;
        System.out.println("建堆前:array[]---->" + Arrays.toString(integers));
        MaxHeap<Integer> integerHeap = new MaxHeap<>(integers);
        System.out.println("建堆后heaps--->" +  integerHeap.toString());
        integerHeap.insert(21);
        System.out.println("insert 21后--->"  +  integerHeap.toString());
        integerHeap.insert(20);
        System.out.println("insert 20后--->" +  integerHeap.toString());
    }

}
