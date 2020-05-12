package com.lqs.study.growup.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: grow-up
 * @description: 第一题
 * @author:luqinshun
 * @create: 2020-03-21 22:28
 **/
public class NoOne {

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 11, 15};
        int target=9;
        int[] result = twoSum(nums, target);
        twoSumMap(nums,target);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length-1;i++){
            int a=nums[i];
            for(int j=i+1;j<nums.length;j++){
                int b=nums[j];
                if(target==(a+b)){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumMap(int[] nums, int target){
        Map<Integer,Integer> sumMap= new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            if(sumMap.containsKey(nums[i])){
                return new int[]{sumMap.get(nums[i]),i};
            }
            sumMap.put(target-nums[i],i);
        }
        return null;
    }
}
