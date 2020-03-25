package com.yh.datastructureandalgorithms.algorithms.sort.Linearsort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {
    public static void main(String[] args) {

        int[]a=new int[10];
        a[0]=100;
        a[1]=120;
        a[2]=80;
        a[3]=89;
        a[4]=0;
        a[5]=51;
        a[6]=5;
        a[7]=5;
        a[8]=46;
        a[9]=43;
        countingSort(a,10);
        for(int aa:a){
         System.out.println(aa);
        }
    }
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max + 1; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤了，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
