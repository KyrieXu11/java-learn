package com.newcode_offer.从头打印链表;

import java.util.ArrayList;

/**
 * @author KyrieXu
 * @since 2020/3/4 13:05
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 **/
public class s01 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(123);
        listNode.next=new ListNode(234);
        listNode.next.next=new ListNode(345);
        listNode.next.next.next = new ListNode(456);
        listNode.next.next.next.next=null;
        ListNode listNode1=null;
        Solution01 solution01=new Solution01();
        ArrayList<Integer> list = solution01.printListFromTailToHead(listNode);
        System.out.println(list.toString());
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution01{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();

        while (listNode!=null){
            list1.add(listNode.val);
            listNode=listNode.next;
        }
        for (int i=list1.size()-1;i>=0;i--){
            list.add(list1.get(i));
        }
        return list;
    }
}


