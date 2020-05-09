package com.newcode_offer.替换空格;

/**
 * @author KyrieXu
 * @since 2020/3/4 12:07
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class s01 {
    public static void main(String[] args) {
        Solution01 solution01 = new Solution01();
        StringBuffer sb = new StringBuffer("We Are Happy");
        String res = solution01.replaceSpace(sb);
        System.out.println(res);
        Solution02 solution02=new Solution02();
        System.out.println(solution02.replaceSpace(sb));
    }
}

class Solution01 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}

class Solution02 {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++; // 统计空格的数量
            }
        }
        int oldLength = str.length();
        int newLength = oldLength + 2 * spaceNum;
        str.setLength(newLength);
        for (int i = oldLength - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                str.setCharAt(i + 2 * spaceNum, str.charAt(i));
            }
            else {
                spaceNum--;
                str.setCharAt(i + 2 * spaceNum, '%');
                str.setCharAt(i + 2 * spaceNum + 1, '2');
                str.setCharAt(i + 2 * spaceNum + 2, '0');
            }
        }
        return str.toString();
    }
}
