package com.lqs.study.growup.algorithm.datatype.link;

/**
 * @program: grow-up
 * @description: 链表中倒数第几个节点
 * @author:luqinshun
 * @create: 2020-05-27 12:33
 **/
public class LastNumLink<T> {

    Node<T> head;

    Node<T> tail;


    /**
     * 使用快慢指针，查找到倒数第几个节点
     * @param head
     * @param lastNum
     */
    public Node<T> lastNumNode(Node<T> head, int lastNum) {
        if (head == null) {
            return null;
        }
        int count = lastNum;
        Node<T> fastNode = head;
        while (count > 0 && fastNode != null) {
            fastNode=fastNode.next;
            count--;
        }

        while(fastNode!=null){
            head=head.next;
            fastNode=fastNode.next;
        }
        return head;
    }


    /**
     * 定义单向链表
     *
     * @param <T>
     */
    class Node<T> {
        T data;

        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
