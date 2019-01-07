package com.yh.datastructureandalgorithms.algorithms.sort.QuickSort;

public class QuickSort {

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
        quickSort(array,12);
        for(int i:array){
            System.out.println(i);
        }
    }
    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                ++i;
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        return i;
    }
}
