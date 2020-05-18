package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 希尔排序
 * @author:luqinshun
 * @create: 2020-05-15 14:39
 **/
public class ShellSort {

    public static void shellSort(int[] arr){
        //第一层，定义步长
        for(int step=arr.length/2;step>0;step=step/2){
            //定义每一步走的位置
            for(int i=step;i<arr.length;i++){
                // 步数多跳
                for(int j=i-step;j>=0;j-=step){
                    if(arr[j+step]<arr[j]){
                        int temp=arr[j];
                        arr[j]=arr[j+step];
                        arr[j+step]=temp;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr=new int[]{23,1,35,89,90,37,26,28,30,77};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
