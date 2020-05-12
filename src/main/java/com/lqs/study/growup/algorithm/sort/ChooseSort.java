package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 选择排序的实现
 * @author:luqinshun
 * @create: 2020-05-12 12:35
 **/
public class ChooseSort {
    public static void  chooseSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[idx]<arr[j]){
                    idx=j;
                }
            }
            if(idx!=i){
                // 则进行交换
                int temp=arr[i];
                arr[i]=arr[idx];
                arr[idx]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{23,1,5,56,12,18,99,75,36};
        chooseSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
