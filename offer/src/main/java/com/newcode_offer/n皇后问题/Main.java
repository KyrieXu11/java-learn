package com.newcode_offer.n皇后问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author KyrieXu
 * @since 2020/4/8 13:14
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> colPlacements = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        solution(n,0,colPlacements,res);
        //for (Integer colPlacement : colPlacements) {
        //    System.out.println(colPlacement);
        //}
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
        }
    }

    public static void solution(int n,int row,List<Integer> colPlacements,List<List<Integer>> res){
        // 满足条件，将结果集返回
        if (row == n){
            res.add(new ArrayList<>(colPlacements));
        }else {
            // 遍历 1~n 列
            for (int i = 0; i < n; i++) {
                // 将列存起来
                colPlacements.add(i);
                if (isValid(colPlacements)){
                    solution(i,row+1,colPlacements,res);
                }
                // 不满足条件移除
                colPlacements.remove(colPlacements.size()-1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacements) {
        // 当前的rowid
        int rowId = colPlacements.size()-1;
        for (int i = 0; i < rowId; i++) {
            // 遍历0 ~ rowId 如果相等或者
            int diff  = Math.abs(colPlacements.get(i)-colPlacements.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }
}
