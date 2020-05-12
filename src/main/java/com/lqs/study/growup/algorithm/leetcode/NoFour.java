package com.lqs.study.growup.algorithm.leetcode;

/**
 * @program: grow-up
 * @description:
 * @author:luqinshun
 * @create: 2020-03-24 21:39
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NoFour {

    public static void main(String[] args) {

        int totalLen=3;
        Boolean isOdd=Boolean.FALSE;
        if((totalLen&1)==1){
            isOdd=Boolean.TRUE;
        }
        if(isOdd){
            System.out.println("奇数");
        }else{
            System.out.println("偶数");
        }
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{-1,3};
        double back = findMedianSortedArrays(nums1, nums2);
        System.out.println(back);
    }

    /**
     *  * nums1 = [1, 2]
     *  * nums2 = [3, 4]
     *  *
     *  * 则中位数是 (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen=nums1.length+nums2.length;
        Boolean isOdd=Boolean.FALSE;
        if((totalLen&1)==1){
            isOdd=Boolean.TRUE;
        }
        int midNumIndex=totalLen/2;
        int i = 0, j = 0,count=0;
        if(nums1.length==0){
            return isOdd?nums2[midNumIndex]:( nums2[midNumIndex-1] + nums2[midNumIndex]) / 2.0;
        }else if(nums2.length==0){
            return isOdd?nums1[midNumIndex]:( nums1[midNumIndex-1] + nums1[midNumIndex]) / 2.0;
        }
        double back=0.0;
        while (i < nums1.length && j < nums2.length) {
            if (!isOdd && (count == (midNumIndex - 1))) {
                back = (nums1[i] + nums2[j]) / 2.0;
                break;
            }
            if (isOdd && count == midNumIndex) {
                if (nums1[i] < nums2[j]) {
                    back = nums1[i];
                    break;
                } else {
                    back = nums2[j];
                    break;
                }
            }
            if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
            count++;
        }
        return back;
    }

}
