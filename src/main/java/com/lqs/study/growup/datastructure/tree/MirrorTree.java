package com.lqs.study.growup.datastructure.tree;

/**
 * 二叉树的镜像定义：源二叉树
 *     	     8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	     8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @program: grow-up
 * @description: 树的镜像
 * @author:luqinshun
 * @create: 2020-06-04 12:23
 **/
public class MirrorTree<T> {

    public void mirror(TreeNode<T> node){
        if(node==null){
            return;
        }
        if((node.left==null)&&(node.left==null)){
            return;
        }
        //记录临时节点
        TreeNode<T> temp=node.left;
        node.left=node.right;
        node.right=temp;
        //通过递归的方式再次遍历
        mirror(node.left);
        mirror(node.right);
    }


    class TreeNode<T>{
        public T data;

        public TreeNode<T> left;

        public TreeNode<T> right;


    }
}
