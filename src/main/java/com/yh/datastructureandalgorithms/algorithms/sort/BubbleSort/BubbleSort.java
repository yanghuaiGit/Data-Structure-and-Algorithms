package com.yh.datastructureandalgorithms.algorithms.sort.BubbleSort;

/**
 * 冒泡排序
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
