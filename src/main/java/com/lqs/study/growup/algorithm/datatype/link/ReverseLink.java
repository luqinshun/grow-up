package com.lqs.study.growup.algorithm.datatype.link;

/**
 * @program: grow-up
 * @description: 反转单向链表
 * @author:luqinshun
 * @create: 2020-05-18 18:17
 **/
public class ReverseLink<T> {
    Node<T> head;

    public void reverseLink(){

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
