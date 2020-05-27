package com.lqs.study.growup.algorithm.datatype.link;

/**
 * @program: grow-up
 * @description: 检测循环链表
 * @author:luqinshun
 * @create: 2020-05-18 18:17
 **/
public class CircleLink<T> {
    Node<T> head;

    Node<T> tail;

    /**
     * 检测循环链表——使用的是快慢指针
     * @param head
     * @return
     */
    public boolean checkCircle(Node<T> head) {
        while (head != null && head.next != null) {
            if (head.next == head.next.next) {
                return true;
            }
        }
        return false;
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
