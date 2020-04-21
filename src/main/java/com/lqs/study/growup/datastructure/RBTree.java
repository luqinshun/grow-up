package com.lqs.study.growup.datastructure;

import ch.qos.logback.core.pattern.color.BlackCompositeConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: grow-up
 * @description: 红黑树
 * @author:luqinshun
 * @create: 2020-04-01 11:12
 **/
public class RBTree<T> {
    public static String BLACK="black";

    public static String RED="red";

    private RBNode<T> root;

    public void put(T t){


        Comparator comparator=(Comparator)t;
        if(root==null){
            //创建对象
        }
        RBNode parent=root;
        do{
            int compare = comparator.compare(t, parent.getData());
            if(compare>0){
                parent=parent.left;
            }
            if(compare<0){
                parent=parent.right;
            }
            if(compare==0){
                parent.setData(t);
                break;
            }
        }while (parent!=null);


        //创建对象

    }

    private void changTree(RBNode node){
        while(node!=root&&node!=null&&node.parent.color==RED){
            //Step1 如果父节点==父节点的父节点的左节点
            //1、如果父节点的兄弟节点为红色，则将父节点和父节点的兄弟节点设置为黑色，将父父节点设置为红色，让父父节点循环
            //2、如果父节点的兄弟节点为黑色或没有节点
            //2.1 插入节点是父节点的左节点，则将父节点设置为黑色，父父节点设置为红色，让父父节点右旋
            //2.2 插入节点是负节点的右几点，则先让父节点左旋，再将父节点设置为2.1的节点操作

            //Step2  如果父节点==父节点的父节点的右节点
            //1、如果父节点的兄弟节点为红色,则将父节点和父节点的兄弟节点置位黑色，父节点的父节点设置为红色，将父节点的父节点设置为迭代对象
            //2、如果父节点的兄弟节点不存在或者为黑色节点
            //2.1 如果插入节点是父节点的右节点，则需要将父节点设置为黑色，父父节点设置为红色，让父父节点左旋
            //2.2 如果插入节点是父节点的左节点，则需要进行父节点右旋，将父节点设置为2.1的操作

        }
        node.setColor(BLACK);
    }

    public void left(RBNode node){
        //Step
//        RBNode parent = node.parent;
//        RBNode right = node.right;
//        parent.right=right;
//        node.parent=node;
//        node.right=right.left;
        //当前节点的右节点，转作为父节点，这个节点转换为左节点
        //子节点的左节点，作为这个节点的右节点


    }

    public void right(RBNode node){

    }

    static final class RBNode<T> {
        private T data;

        private RBNode left;

        private RBNode right;

        private RBNode parent;

        private String color= BLACK;

        public RBNode(T data, RBNode parent, String color) {
            this.data = data;
            this.parent = parent;
            this.color = color;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
