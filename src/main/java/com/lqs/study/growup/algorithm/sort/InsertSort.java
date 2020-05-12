package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 插入排序
 * @author:luqinshun
 * @create: 2020-05-11 12:44
 **/
public class InsertSort {
    public static void  insertSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(temp<arr[j]){
                    //相连的比较
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{12,3,56,23,89,16,75,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
