package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 计数排序算法
 * @author:luqinshun
 * @create: 2020-05-18 15:38
 **/
public class CountSort {
    /**
     * 适用场景：
     *  1、 排序数据为整数
     *  2、 最大值和最小值范围小
     * @param arr
     */
    public static int[] countSort(int[] arr){
        //Step1 获取到数组最大值和最小值
        int max=arr[0];
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        //Step2 记录到数组中
        int[] countArr=new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            int arrValue = arr[i];
            int count=countArr[arrValue-min];
            if(count==0){
                countArr[arrValue-min]=1;
            }else{
                countArr[arrValue-min]=count+1;
            }

        }
        //Step3 按照顺序会写到表中
        int newIndex=0;
        int[] newArr=new int[arr.length];
        for(int j=0;j<countArr.length;j++){
            int count = countArr[j];
            if(count!=0){
                while(count>0){
                    int value=j+min;
                    newArr[newIndex]=value;
                    newIndex++;
                    count--;
                }
            }
        }
        return newArr;
    }


    public static void main(String[] args) {
        int[] arr=new int[]{55,23,12,56,15,78,3,5,5,8,8,9};
        int[] newArr = countSort(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
