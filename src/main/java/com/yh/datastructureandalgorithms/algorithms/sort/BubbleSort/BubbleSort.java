package com.yh.datastructureandalgorithms.algorithms.sort.BubbleSort;

/**
 * 冒泡排序
 * 只涉及到相邻数据的交换操作，只需要常量级的临时空间，所以时间复杂度为o(1)，是一个原地排序算法
 * 稳定的排序算法  如果相邻的两个元素的大小相等的时候，不做交换
 */
public class BubbleSort {
    //a表示数组，b表示数组大小
    public void bubbleSort(int[]a,int n){
        if(n<=1){
            return;
        }
       for(int i=0;i<n;++i){
           //提前退出冒泡排序标志位
           boolean flag=false;
           for(int j=0;j<n-i-1;++j){
               if(a[j]>a[j+1]){
                   int tmp=a[j];
                   a[j]=a[j+1];
                   a[j+1]=tmp;
                   flag=true;
               }
           }
           if(!flag) break;//没有交换数据，提前退出
       }

    }
}
