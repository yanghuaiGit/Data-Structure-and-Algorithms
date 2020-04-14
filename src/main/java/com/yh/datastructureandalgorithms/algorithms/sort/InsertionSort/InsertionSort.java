package com.yh.datastructureandalgorithms.algorithms.sort.InsertionSort;


/**
 * 插入排序
 * 原地
 * 稳定
 * O(n^2)
 */
public class InsertionSort {
    public static void main(String[]args){
    int a[]= new int [6];
    a[0]=4;a[1]=5;a[2]=6;a[3]=1; a[4]=3; a[5]=2;
        insertionSort(a,6);
        for(int c:a){
            System.out.println(c);
        }

            }

    // 插入排序，a 表示数组，n 表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        int count=0;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                    count++;// 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
        System.out.println("移动次数"+count);
    }


}
