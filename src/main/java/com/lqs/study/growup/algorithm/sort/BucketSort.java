package com.lqs.study.growup.algorithm.sort;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: grow-up
 * @description: 桶排序
 * @author:luqinshun
 * @create: 2020-05-22 12:07
 **/
public class BucketSort {
    public static int[] bucketSort(int[] arr) {
        int max=arr[0];
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        int bucketCount=(max-min)/arr.length;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        //初始化桶
        for(int n=0;n<bucketCount;n++){
            bucketList.add(new ArrayList());
        }
        for(int m=0;m<arr.length;m++){
            //计算桶的位置
            int bucketIndex=(arr[m]-min)*(bucketCount-1)/(max-min);
            ArrayList list = bucketList.get(bucketIndex);
            list.add(arr[m]);
        }
        //将桶内的数据，进行排序
        for(ArrayList list: bucketList){
            Collections.sort(list);
        }
        int[] sortArr=new int[arr.length];
        int index=0;
        //复制到数组
        for (ArrayList<Integer> list: bucketList){
            for(Integer num: list){
                sortArr[index]=num;
                index++;
            }
        }
        return sortArr;

    }

    public static void main(String[] args) {
        int[] arr=new int[]{12,52,36,3,96,85,76,5,15,66,23,88};
        int[] newArr = bucketSort(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
