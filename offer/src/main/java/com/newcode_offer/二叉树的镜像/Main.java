package com.newcode_offer.二叉树的镜像;

/**
 * @author KyrieXu
 * @since 2020/4/10 16:01
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 **/
public class Main {
    public static void main(String[] args) {
    }

    public static void Mirror(TreeNode root) {
        if (root==null)
            return;
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        val = x;
    }
}
