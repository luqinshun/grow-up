package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 堆排序
 * @author:luqinshun
 * @create: 2020-05-15 14:39
 **/
public class DumpSort {
    public static void dumpSort(int[] arr) {
        // 构建初始堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            buildDump(arr, i, arr.length);
        }
        // 头结点和尾结点交换
        for (int j = arr.length - 1; j > 0; j--) {
            //交换头尾节点
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            //再次构建
            buildDump(arr, 0, j);
        }

    }

    /**
     * 构建大顶堆，子节点比父节点小
     * @param arr
     * @param i
     * @param length
     */
    public static void buildDump(int[] arr, int i, int length) {
        // 父节点的值
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //比较k的兄弟节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if(temp>arr[k]){
                break;
            }
            // 下沉
            arr[i] = arr[k];
            i = k;
        }
        arr[i] = temp;
    }


    /**
     *  [12,45,65,23,5,78,89,32,56]
     *   0  1  2  3  4  5  6  7  8
     *           12
     *          / \
     *        45  65
     *       / \  / \
     *      23 5 78 89
     *     / \
     *    32 56
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr=new int[]{12,45,65,23,5,78,89,32,56};
        dumpSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
