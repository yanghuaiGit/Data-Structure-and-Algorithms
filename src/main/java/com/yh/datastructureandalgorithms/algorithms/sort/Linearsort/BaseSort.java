package com.yh.datastructureandalgorithms.algorithms.sort.Linearsort;

/**
 * 基数排序 本质还是桶排序 只不过是对每个数进行按位桶排序，低位不会改变高位的状态
 * https://www.jianshu.com/p/1fad0269e378
 */

/**
 * TODO 这个排序实现每位排序之后 需要复制到原数组中 再对原数组进行下一位的排序
 * TODO 实际上可以优化为每位排序之后不需要再赋值回去，可以直接再原bucket里进行操作完之后 最后一次结束了 再赋值回去
 *
 */
public class BaseSort {

    /**
     * @param array 需要排序的对象
     * @param d     最大的位数
     */
    private static void radixSort(int[] array, int d) {

        //代表位数对应的数1,10,100
        int n = 1;
        int length = array.length;
        //排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[][] bucket = new int[10][length];
        //用于保存每个桶里有多少个数字
        int[] order = new int[length];
        //从个位开始进行排序(从低位开始排序)
        while (n < d) {
            //将数组array里的每个数字放在相应的桶里
            for (int num : array) {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }

            //保存每一位排序后的结果用于下一位的排序输入
            int k = 0;
            //将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            for (int i = 0; i < 10; i++) {
                //如果这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                //将桶里计数器置0，用于下一次位排序
                order[i] = 0;
            }
            n *= 10;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{73, 23, 44, 32, 94, 56, 32, 45, 656,990};
        radixSort(data, 1000);
        for (int a : data) {
            System.out.print(a + "  ");
        }

    }

}
