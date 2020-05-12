package com.lqs.study.growup.algorithm.sort;

import org.apache.curator.shaded.com.google.common.collect.Lists;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 冒泡排序算法
 * @author:luqinshun
 * @create: 2020-05-11 12:30
 **/
public class BubbleSort {

    /**
     * 相连的数据相比较，排好的顺序是由后往前
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                int temp=arr[j];
                if(temp>arr[j+1]){
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    /**
     * 冒泡排序的改良版，鸡尾酒排序
     * @param arr
     */
    public static void cocktailSort(int[] arr){

    }

    public static void main(String[] args) {
        int[] arr=new int[]{69,5,12,15,32,66,25};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
