package com.yh.datastructureandalgorithms.algorithms.sort.Mergesort;

import java.util.Arrays;
import java.util.List;

/**
 * 归并排序
 * 稳定 非原地
 * o(nlog m) 任何场景下时间复杂度都是一样的
 */
public class merge_sort {
    public static void main(String[] args) {
        int []array=new int[12];
        array[0]=2;
        array[1]=7;
        array[2]=4;
        array[3]=9;
        array[4]=5;
        array[5]=0;
        array[6]=12;
        array[7]=56;
        array[8]=34;
        array[9]=87;
        array[10]=56;
        array[11]=79;
        mergeSort(array,12);
        for(int i:array){
            System.out.println(i);
        }
    }

    // 归并排序算法, a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p) / 2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1  在这儿保证了是稳定的排序算法
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r - p; ++i) {
            a[p + i] = tmp[i];
        }
    }
}
