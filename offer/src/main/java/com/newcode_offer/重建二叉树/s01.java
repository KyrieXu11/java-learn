package com.newcode_offer.重建二叉树;

/**
 * @author KyrieXu
 * @since 2020/3/21 15:34
 **/
public class s01 {
    public static void main(String[] args) {
        Solution01 s=new Solution01();
        int[] pre=new int[]{1,2,4,7,3,5,6,8};
        int[] in=new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode = s.reConstructBinaryTree(pre, in);
        s.PrintBinTree(treeNode);

    }
}

class Solution01{
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length==0||in.length==0)
            return null;
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,pre.length-1);
    }

    /**
     * 递归构造出二叉树
     * @param pre 先序遍历的序列
     * @param startPre 先序遍历的开始位置
     * @param endPre 先序遍历的结束位置
     * @param in 中序遍历序列
     * @param startIn 中序遍历的开始位置
     * @param endIn 中序遍历的结束位置
     * @return 二叉树
     */
    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        // 如果各个节点的开始位置大于结束位置，就说明已经到空节点了
        if (startIn>endIn||startPre>endPre)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            // 在中序序列中找到根节点
            if (pre[startPre]==in[i]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    public void PrintBinTree(TreeNode treeNode){
        if (treeNode ==null)
            return;
        System.out.println(treeNode.val);
        PrintBinTree(treeNode.left);
        PrintBinTree(treeNode.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
