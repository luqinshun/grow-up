package com.lqs.study.growup.algorithm.datatype.link;

/**
 * @program: grow-up
 * @description: 反转单向链表
 * @author:luqinshun
 * @create: 2020-05-18 18:17
 **/
public class ReverseLink<T> {
    Node<T> head;

    Node<T> tail;

    public void reverseLink() {
        reverse(this.head);
    }

    public void add(T t) {
        Node<T> tNode = new Node<>(t);
        if (head == null) {
            head = tNode;
            tail = tNode;
        }
        tail.next = tNode;
    }


    /**
     * 方式一：通过递归的方式
     *
     * @param node
     */
    private void reverse(Node<T> node) {
        // 记录下一个节点为父节点
        Node<T> newParent = node.next;
        if (newParent == null || node == null) {
            head = node;
        }
        //递归调用
        reverse(newParent);
        // 将父节点next设置
        newParent.next = node;
        head.next = null;
    }

    /**
     * 方式二：迭代的方式
     */
    public Node<T> foreachReverse(Node<T> head) {
        Node<T> pre=null;
        Node<T> next=null;
        while ( head != null) {
            //标记下一个几点
            next=head.next;
            //在需要一个迭代中反转
            head.next=pre;
            //将原来的首节点记录
            pre=head;
            head=next;
        }
        return pre;
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
