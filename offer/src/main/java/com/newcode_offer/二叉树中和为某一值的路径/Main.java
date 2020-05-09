package com.newcode_offer.二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * @author KyrieXu
 * @since 2020/4/23 12:59
 **/
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        for (ArrayList<Integer> list : FindPath(treeNode, 2)) {
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root != null)
            FindPath(root, target, res, path);
        return res;
    }


    private static void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> path) {
        path.add(root.val);
        ArrayList<Integer> list = new ArrayList<>(path.size());
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                // 由于path是引用类型的
                // 所以需要创建一个新列表来保存结果
                list.addAll(path);
                lists.add(list);
            }
        }
        if (root.left != null)
            FindPath(root.left, target - root.val, lists, path);
        if (root.right != null)
            FindPath(root.right, target - root.val, lists, path);
        // 回退上一层需要将元素给删除
        path.remove(path.size() - 1);
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
