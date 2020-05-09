package com.newcode_offer.二叉搜索树的后序遍历序列;

/**
 * @author KyrieXu
 * @since 2020/4/20 11:00
 **/
public class Main {
    public static void main(String[] args) {
        int[] seq = new int[]{4, 5, 8, 10, 9, 7};
        System.out.println(VerifySquenceOfBST(seq));
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return judgeSequence(sequence, 0, sequence.length - 1);
    }

    private static boolean judgeSequence(int[] sequence, int begin, int end) {
        // 这个是因为都递归到了这个条件，说明左子树的值一定的小于右子树的
        if (begin > end)
            return true;
        int i = begin, j;
        // 找到比根节点小的数
        while (sequence[i] < sequence[end])
            i++;
        j = i;
        i -= 1;
        // 如果右子树有比根节点小的，那么一定不是后序遍历序列
        for (int k = j; k <= end; k++) {
            if (sequence[k] < sequence[end])
                return false;
        }
        boolean left = judgeSequence(sequence, begin, i);
        boolean right = judgeSequence(sequence, j, end - 1);
        return left && right;
    }
}
