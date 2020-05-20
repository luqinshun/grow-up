package com.lqs.study.growup.algorithm.datatype.link;

/**
 * @program: grow-up
 * @description: 链表
 * @author:luqinshun
 * @create: 2020-05-18 18:18
 **/
public class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public void add(T t){
        Node<T> tNode = new Node<>(t);
        if(head==null){
            head =tNode;
            tail=tNode;
        }
        tail.next=tNode;
    }

    /**
     * 定义单向链表
     * @param <T>
     */
    class Node<T>{
        T data;

        Node<T> next;

        Node(T data){
            this.data=data;
        }
    }
}
