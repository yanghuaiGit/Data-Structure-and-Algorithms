package com.yh.datastructureandalgorithms.algorithms.Search;

public class BaseBinarySearch {
    public static void main(String[] args) {

    }

      //非递归解决
        public static  int bsearch(int[] a, int n, int value) {
            int low = 0;
            int high = n - 1;

            while (low <= high) {//循环退出条件low<=high不是low<high
                //int mid = (low + high) / 2;
                int mid =  low+((high-low)>>1);
                if (a[mid] == value) {
                    return mid;
                } else if (a[mid] < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }


        //递归解决
        // 二分查找的递归实现
        public static  int bsearchB(int[] a, int n, int val) {
            return bsearchInternally(a, 0, n - 1, val);
        }

    private static  int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }


}
