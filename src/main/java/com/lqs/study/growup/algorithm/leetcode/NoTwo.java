package com.lqs.study.growup.algorithm.leetcode;

/**
 * @program: grow-up
 * @description: 题目二
 * @author:luqinshun
 * @create: 2020-03-21 23:02
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class NoTwo {

    public static void main(String[] args) {
        int i=11%10;
        System.out.println(i);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    /**
     * 递归的方式
     * @param l1
     * @param l2
     * @param i
     * @param back
     * @return
     */
    public ListNode addTwo(ListNode l1, ListNode l2, int i, ListNode back) {
        int a = 0, b = 0;
        ListNode nextNode1=null,nextNode2=null;
        if (l1 != null) {
            a = l1.val;
            nextNode1=l1.next;
        }
        if (l2 != null) {
            b = l2.val;
            nextNode2=l2.next;
        }
        int c = a + b + i;
        if (l1 == null && l2 == null && i == 0) {
            return back;
        }
        if (c < 10) {
            ListNode listNodeC = new ListNode(c);
            if (back == null) {
                back = listNodeC;
            } else {
                back.next = listNodeC;
            }
            if(l1==null&&l2==null){
                return back;
            }
            addTwo(nextNode1, nextNode2, 0, listNodeC);
        } else {
            int c1 = c % 10;
            ListNode listNodeC = new ListNode(c1);
            if (back == null) {
                back = listNodeC;
            } else {
                back.next = listNodeC;
            }
            if (l1 == null && l2 == null) {
                return back;
            }
            addTwo(nextNode1, nextNode2, 1, listNodeC);
        }
        return back;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }


 }
