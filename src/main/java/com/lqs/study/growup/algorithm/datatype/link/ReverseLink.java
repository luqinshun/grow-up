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
        reverse(this.head);
    }


    /**
     * 通过递归的方式
     * @param node
     */
    private void reverse(Node<T> node){
        // 记录下一个节点为父节点
        Node<T> newParent = node.next;
        if(newParent==null||node==null){
            head=node;
        }
        //递归调用
        reverse(newParent);
        // 将父节点next设置
        newParent.next=node;
        head.next=null;
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
