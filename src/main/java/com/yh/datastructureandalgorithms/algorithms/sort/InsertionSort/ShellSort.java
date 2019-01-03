package com.yh.datastructureandalgorithms.algorithms.sort.InsertionSort;

/**
 * 希尔排序 基于直接插入排序改进
 */
public class ShellSort {
    public static void main(String[] args) {

        int[] arr = new int[]{44,33,99,10,30,20,59,78,23,48};
        System.out.print("排序前：");
        for(int o: arr) {
            System.out.print(o+" ");
        }
        System.out.println();
        shellSort(arr);
        System.out.print("排序后：");
        for(int o: arr) {
            System.out.print(o+" ");
        }
        System.out.println();
    }
    private static void shellSort(int[] arr) {



        int j;
        int len = arr.length;
        for(int val=len>>1; val>0; val>>=1) {
            //下面是对本次的所有分组做直接插入排序
            for(int i=val; i<len; i++) {//i等于val 就是分组后需要进行比较的第二个数，即第一个数位置加上步长，第一个数位置都是0，所以就是步长val
                int temp = arr[i];
                //val就是分组的步长 大小是长度的一半，就是后半部分和前半部分进行比较操作
                /*
                 * 为什么每次都用temp比较呢？
                 * 因为直接插入就是找到temp的合适位置。
                 * 为什么temp<arr[j-val]这个条件可以放在for内呢？
                 * 因为原来的组内数据已经有序，找到位置就停止便是。
                 * 不甚理解的去看直接插入排序吧。
                 */
                for(j=i; j>=val&&temp<arr[j-val]; j-=val) {
                    /*
                     * 为什么是arr[j-val]不是arr[j]呢？
                     * 因为j=i开始的，而且条件是j>=val&&temp<arr[j-val]
                     */
                    arr[j] = arr[j-val];
                }
                /*
                 * 注意不是arr[i] = temp
                 * 直接插入排序也是这样的。
                 * 为什么呢？
                 * 因为j是位置，i是待插入元素
                 */
                arr[j] = temp;
            }
        }
    }
}
