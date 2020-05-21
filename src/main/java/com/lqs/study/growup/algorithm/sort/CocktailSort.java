package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 鸡尾酒排序算法
 * @author:luqinshun
 * @create: 2020-05-21 12:08
 **/
public class CocktailSort {

    public static void cocktailSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length/2;i++){
            boolean isSort=true;
            for(int j=i;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSort=false;
                }
            }
            if(isSort){
                break;
            }

            for(int n=arr.length-i-1;n>i;n--){
                if(arr[n-1]>arr[n]){
                    temp=arr[n];
                    arr[n]=arr[n-1];
                    arr[n-1]=temp;
                    isSort=false;
                }
            }
            if(isSort){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{13,56,89,7,25,31,96,22,68,99,1,2};
        cocktailSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
