package com.lqs.study.growup.leetcode;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @program: grow-up
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author:luqinshun
 * @create: 2020-03-22 11:46
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NoThree {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring2("abcabcbb");
        System.out.println(length);
    }

    //pwwkew

    /**
     * 暴力解题法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=length;i>0;i--){
            Loop:
            for(int j=0;j+i<=length;j++){
                String subStr = s.substring(j, j+i);
                char[] subChars = subStr.toCharArray();
                for(int m=0;m<subChars.length;m++){
                    char subChar = subChars[m];
                    Integer num = map.get(subChar);
                    if(num!=null&&i==num.intValue()){
                        map.clear();
                        continue Loop;
                    }
                    map.put(subChars[m],i);
                }
                return i;
            }
        }
        return length;
    }

    //"pwwkew"
    public static int lengthOfLongestSubstring1(String s) {

        int length = s.length();
        for(int i=length;i>0;i--){
            for(int j=0;j+i<=length;j++){
                String subStr = s.substring(j, j+i);
                char[] subChars = subStr.toCharArray();
                HashSet set=new HashSet<>();
                for(int m=0;m<subChars.length;m++){
                    char subChar = subChars[m];
                    boolean contains = set.contains(subChar);
                    if(contains){
                        continue;
                    }
                    set.add(subChars[m]);
                }
                if(i==set.size()){
                    return i;
                }
            }
        }
        return length;
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        HashSet hashSet = new HashSet();
        int length = s.length();
        int i = 0, j = 0, m = 0;
        while(i<length&&j<length){
            if(!hashSet.contains(s.charAt(i))){
                hashSet.add(i++);
                m=Math.max(m,i-j);
            }else{
                hashSet.remove(s.charAt(j--));
            }
        }
        return m;
    }
}
