package com.newcode_offer.树的子结构;

/**
 * @author KyrieXu
 * @since 2020/4/10 15:23
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 **/
public class Main {
    public static void main(String[] args) {

    }

    public static boolean hasSubTree(TreeNode root1, TreeNode root2){
        boolean res = false;
        // 空树直接返回false
        if (root1!=null&&root2!=null){
            if (root1.val==root2.val){
                // 根节点匹配上了就从根节点开始找
                res = rootJudge(root1,root2);
            }
            // 去左子树找有没有相同的子结构
            if (!res){
                res = hasSubTree(root1.left,root2);
            }
            // 左子树没找到就去右子树找
            if (!res){
                res = hasSubTree(root1.right,root2);
            }
        }
        return res;
    }

    public static boolean rootJudge(TreeNode root1,TreeNode root2){
        // 子树为空，遍历完成返回true
        if (root2==null)
            return true;
        // 小树没遍历完成，但是大树遍历完了返回false
        if(root1==null)
            return false;
        // 值不想等，返回false
        if (root1.val!=root2.val)
            return false;
        // 根节点找到了对应的就去左右子树找到有没有对应上的
        return rootJudge(root1.left,root2.left)&&rootJudge(root1.right,root2.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}