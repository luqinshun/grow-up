package com.lqs.study.growup.algorithm.datatype.queue;

import java.util.Queue;

/**
 * @program: grow-up
 * @description: 基于链表实现队列
 * @author:luqinshun
 * @create: 2020-05-18 17:42
 **/
public class LinkedQueue<T> {
    Node<T> head;

    Node<T> tail;

    public void enqueue(T t){
        if(head==null){
            head=new Node<T>(t);
            tail=head;
            return;
        }
        //Queue
        Node<T> addNode = new Node<>(t);
        addNode.setBefore(tail);
        tail.setNext(addNode);
    }

    public T dequeue(){
        if(head==null){
            return null;
        }
        T headData = head.data;
        Node<T> newHead = head.next;
        newHead.setBefore(null);
        head=newHead;
        return headData;
    }

    class Node<T>{
        T data;
        Node<T> next;
        Node<T> before;

        Node(T data){
            this.data=data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getBefore() {
            return before;
        }

        public void setBefore(Node<T> before) {
            this.before = before;
        }
    }

}
