package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 归并排序的实现
 * @author:luqinshun
 * @create: 2020-05-13 12:42
 **/
public class MergeSort {
    public static void mergeSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int middle=(start+end)/2;
        mergeSort(arr,start,middle);
        mergeSort(arr,middle+1,end);
        swipe(arr,start,end,middle);
    }

    public static void swipe(int[] arr,int start,int end,int middle){
        int i=start;
        int j=end;
        int m=middle+1;
        //需要创建一个临时的数组，存放归并的数据
        int[] tempArr=new int[end-start+1];
        int k=0;
        while(i<=middle&&m<=j){
            if(arr[i]<=arr[m]){
                tempArr[k++]=arr[i++];
            }else{
                tempArr[k++]=arr[m++];
            }

        }
        while(i<=middle){
            tempArr[k++]=arr[i++];
        }
        while(m<=end){
            tempArr[k++] =arr[m++];
        }
        //将数据复制给原数组
        for(int c=0;c<tempArr.length;c++){
            arr[start+c]=tempArr[c];
        }
    }



    public static void main(String[] args) {
        int[] arr=new int[]{25,56,13,78,89,15,17,88,39};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
