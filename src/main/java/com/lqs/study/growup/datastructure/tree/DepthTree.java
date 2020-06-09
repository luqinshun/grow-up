package com.lqs.study.growup.datastructure.tree;

/**
 * @program: grow-up
 * @description: 查询树的深度
 * @author:luqinshun
 * @create: 2020-06-05 15:32
 **/
public class DepthTree<T> {


    /**
     * 得到树的最大深度，也就是树的高度
     * @param node
     * @return
     */
    public int maxDepth(TreeNode<T> node){
        if(node==null){
            return 0;
        }
        int leftDepth=maxDepth(node.left);
        int rightDepth=maxDepth(node.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    /**
     * 获取树的最小深度
     * @param node
     * @return
     */
    public int minDepth(TreeNode<T> node){
        if(node==null){
            return 0;
        }
        int leftDepth=minDepth(node.left);
        int rightDepth=minDepth(node.right);
        return Math.min(leftDepth,rightDepth)+1;
    }

    /**
     * 获取树的所有节点数
     * @param node
     * @return
     */
    public int treeNodeNum(TreeNode<T> node){
        if(node==null){
            return 0;
        }
        return treeNodeNum(node.left)+treeNodeNum(node.right)+1;
    }



    class TreeNode<T>{
        public T data;

        public TreeNode<T> left;

        public TreeNode<T> right;


    }
}
