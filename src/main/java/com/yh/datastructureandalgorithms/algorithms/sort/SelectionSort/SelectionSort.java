package com.yh.datastructureandalgorithms.algorithms.sort.SelectionSort;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int a[]=new int[6];

        a[0]=10;
        a[1]=4;
        a[2]=7; a[3]=9; a[4]=12; a[5]=8;
        SelectionSort(a,6);
        for(int b:a){
          System.out.println(b);
        }

    }

    public static  void SelectionSort(int [] arr,int n){

        //i<n-1 最后一个位置是不需要排序的
        for(int i = 0; i < n - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < n; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }

    }
/*    public static  void SelectionSort(int [] a,int n){

        for(int j=0;j<n-1;j++){
            int min=a[j];
            for(int i=j+1;i<n;i++){
                if( a[i]<min){
                    min=a[i];
                }
            }
            a[j]=min;
        }

    }*/
}
