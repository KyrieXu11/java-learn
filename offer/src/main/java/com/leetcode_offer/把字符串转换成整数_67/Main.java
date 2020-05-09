package com.leetcode_offer.把字符串转换成整数_67;

/**
 * @author KyrieXu
 * @since 2020/5/8 9:38
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(strToInt("-91283472332"));
    }

    public static int strToInt(String str) {
        long res=0;
        // 去掉前面的空格
        str=str.trim();
        if (str.length()==0)
            return 0;
        int i=0;
        boolean minus = false;
        // 判断第一个是否为数字，或者正负号
        if(!Character.isDigit(str.charAt(i))&&str.charAt(i)!='+'&&str.charAt(i)!='-')
            return 0;
        if(str.charAt(i)=='-'){
            minus=true;
            ++i;
        }
        else if(str.charAt(i)=='+')
            ++i;
        // 是数字的话就一直累加
        while(i<str.length()&&Character.isDigit(str.charAt(i))){
            res=res*10+str.charAt(i)-'0';
            // 判断数字是否正溢出
            if(!minus &&res>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(minus &&-res<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            ++i;
        }
        return minus?-(int)res:(int)res;
    }
}
