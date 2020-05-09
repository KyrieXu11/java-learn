package com.newcode_offer.二维数组的查找;

/**
 * @author KyrieXu
 * @since 2020/3/4 11:22
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class s01 {
    public static void main(String[] args) {
        Solution01 solution01=new Solution01();
        int[][] array=new int[][]{{1,2,3},{2,3,4}};
        System.out.println(solution01.Find(1, array));
    }

}

class Solution01 {
    public boolean Find(int target, int[][] array) {
        boolean found = false;
        int rows = array.length ; // 获取行数
        int columns = array[rows - 1].length ; // 获取列数
        if (columns > 0) { // 如果行数和列数都大于0就可以开始找了
            int row = 0, column = columns - 1;    // 因为是先找右上角的，所以让row为0，column为列数减一
            while (row < rows && column >= 0) {
                if (array[row][column] > target) {
                    column--;
                }
                else if (array[row][column] < target)
                    row++;
                else {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }
}
