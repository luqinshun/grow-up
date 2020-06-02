package com.lqs.study.growup.datastructure.tree;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @program: grow-up
 * @description: 定义树
 * @author:luqinshun
 * @create: 2020-05-29 20:16
 **/
public class SimpleTree<T> {
    private TreeNode<T> root;

    /**
     * 递归的方式:实现前序遍历
     */
    public void beforeTraversal(TreeNode<T> node){
        System.out.println(node.data);
        beforeTraversal(node.left);
        beforeTraversal(node.right);
    }

    /**
     * 递归的方式：实现中序遍历
     * @param node
     */
    public void middleTraversal(TreeNode<T> node){
        middleTraversal(node.left);
        System.out.println(node.data);
        middleTraversal(node.right);
    }

    /**
     * 递归的方式：实现后序遍历
     * @param node
     */
    public void afterTraversal(TreeNode<T> node){
        afterTraversal(node.left);
        afterTraversal(node.right);
        System.out.println(node.data);
    }

    /**
     * 迭代的方式： 实现前序遍历
     * @param node
     */
    public List<T> beforeTraversalForeach(TreeNode<T> node){
        if(node==null){
            return Lists.newArrayList();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<T> dataList=new ArrayList<>();
        //先添加Root
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode<T> temp = stack.pop();
            T data = temp.data;
            dataList.add(data);
            //后面才出来
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        return dataList;
    }

    /**
     * 迭代的方式： 实现后序遍历
     * @param node
     * @return
     */
    public List<T> afterTraversalForeach(TreeNode<T> node){
        if(node==null){
            return Lists.newArrayList();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<T> dataList=new ArrayList<>();
        //添加root节点
        stack.push(node);
        while(!stack.isEmpty()){
            TreeNode<T> temp = stack.pop();
            dataList.add(temp.data);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        //再反转List
        Collections.reverse(dataList);
        return dataList;
    }

    /**
     * 迭代的方式： 实现中序遍历
     * @param node
     * @return
     */
    public List<T> middleTraversalForeach(TreeNode<T> node){
        if(node==null){
            return Lists.newArrayList();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<T> dataList= new ArrayList<>();
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                //添加数据，并将节点转向右节点
                TreeNode<T> temp = stack.pop();
                dataList.add(temp.data);
                node=node.right;
            }
        }
        return dataList;
    }

    /**
     * 使用队列的方式：实现层次遍历
     * @param node
     */
    public List<T> levelTraversalForeach(TreeNode<T> node){
        if(node==null){
            return Lists.newArrayList();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        List<T> dataList=new ArrayList<>();
        while(!CollectionUtils.isEmpty(queue)){
            TreeNode<T> temp = queue.poll();
            dataList.add(temp.data);
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        return dataList;
    }

    /**
     * 递归的方式实现层次遍历
     * @param node
     * @return
     */
    public List<T> levelTraversal(TreeNode<T> node){
        if(node==null){
            return Lists.newArrayList();
        }
        List<T> dataList=new ArrayList<>();
        addLevelTraversal(node,dataList);
        return dataList;
    }


    public void addLevelTraversal(TreeNode<T> node,List<T> dataList){
        dataList.add(node.data);
        if(node.left!=null){
            addLevelTraversal(node.left,dataList);
        }
        if(node.right!=null){
            addLevelTraversal(node.right,dataList);
        }
    }


    class TreeNode<T>{
        public T data;

        public TreeNode<T> left;

        public TreeNode<T> right;


    }
}
