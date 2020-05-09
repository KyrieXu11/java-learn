package com.newcode_offer.二叉搜索树与双向链表;

/**
 * @author KyrieXu
 * @since 2020/4/24 11:15
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 **/
public class Main {
    public static void main(String[] args) {
        int[] pre = new int[]{10, 6, 4, 8, 14, 12, 16};
        int[] in = new int[]{4, 6, 8, 10, 12, 14, 16};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        TreeNode convert = Convert(treeNode);
        PrintBinTree(convert);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    protected static TreeNode lastNode = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);
        TreeNode res = lastNode;
        while (res != null && res.left != null) {
            res = res.left;
        }
        return res;
    }

    private static void ConvertNode(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        if (pRootOfTree.left != null)
            ConvertNode(pRootOfTree.left);
        pRootOfTree.left = lastNode;
        if (lastNode != null)
            lastNode.right = pRootOfTree;
        lastNode = pRootOfTree;
        if (pRootOfTree.right != null)
            ConvertNode(pRootOfTree.right);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, pre.length - 1);
    }

    /**
     * 递归构造出二叉树
     *
     * @param pre      先序遍历的序列
     * @param startPre 先序遍历的开始位置
     * @param endPre   先序遍历的结束位置
     * @param in       中序遍历序列
     * @param startIn  中序遍历的开始位置
     * @param endIn    中序遍历的结束位置
     * @return 二叉树
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        // 如果各个节点的开始位置大于结束位置，就说明已经到空节点了
        if (startIn > endIn || startPre > endPre)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            // 在中序序列中找到根节点
            if (pre[startPre] == in[i]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void PrintBinTree(TreeNode treeNode) {
        TreeNode tmp = treeNode;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.right;
        }
    }
}
