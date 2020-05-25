package com.lqs.study.growup.algorithm.sort;

import java.util.Arrays;

/**
 * @program: grow-up
 * @description: 基数排序
 * @author:luqinshun
 * @create: 2020-05-25 12:08
 **/
public class RadixSort {

    public static void radixSort(int[] arr,int max){
        //位数标识
        int min=1;
        //位数*10；
        int n=1;
        //临时数组的角标
        int k=0;
        //定义二维数组 ，存储基数和对应的数据
        int[][] temp=new int[10][arr.length];
        //存储基数数组有多少个
        int[] radixCountArr=new int[10];
        while(min<=max){
            //先构建基数桶
            for(int i=0;i<arr.length;i++){
                //计算基数
                int radixNum=(arr[i]/n)%10;
                //基数的大小，和所在位置
                temp[radixNum][radixCountArr[radixNum]]=arr[i];
                radixCountArr[radixNum]++;
            }
            //将构建好的基数数组，回写到数组中
            for(int i=0;i<10;i++){
                if(radixCountArr[i]!=0){
                    //则开始迭代
                    for(int j=0;j<radixCountArr[i];j++){
                        arr[k]=temp[i][j];
                        k++;
                    }
                }
                radixCountArr[i]=0;
            }
            n*=10;
            min++;
            //数组重新置空
            k=0;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,52,23,86,75,96,1112,63,1,8,561};
        radixSort(arr,4);
        System.out.println(Arrays.toString(arr));
    }
}
