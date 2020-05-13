package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 快速排序
 * @author:luqinshun
 * @create: 2020-05-13 11:58
 **/
public class QuickSort {
    /**
     * 采用分治思想实现，定位到一个点，左边的都比它小，右边的都比它大
     */
    public static void quickSort(int[] arr,int start,int end){
        if(start>end){
            return;
        }
        int middle=binarySort(arr,start,end);
        //找到中间的数据后，其实就不用这个坐标
        quickSort(arr,start,middle-1);
        quickSort(arr,middle+1,end);
    }

    public static int binarySort(int[] arr,int start,int end){
        int i=start;
        int j=end;
        // 以第一个值为标准
        int temp=arr[i];

        while(i<j){
            //从最右边开始，如果比temp值小，不断找下一个，否则进行值的交换
            while(temp<=arr[j]&&i<j){
                j--;
            }
            //从最左边开始，如果比temp值大，不断找下一个，否则进行值的交换
            while(temp>=arr[i]&&i<j){
                i++;
            }
            // 进行值的交换
            if(i<j){
                int t=arr[j];
                arr[j]=arr[i];
                arr[i]=t;
            }

        }
        // 比较完毕后，中间的点已经寻找出来，需要将第一个比较值，替换为middle值
        arr[start]=arr[i];
        arr[i]=temp;
       return j;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,16,55,62,36,5,14,78,99,102,9,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
