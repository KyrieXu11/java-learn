package com.leetcode_offer.两个链表的第一个公共节点_52;

/**
 * @author KyrieXu
 * @since 2020/5/11 12:08
 **/
public class Main {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;

        while (h1 != h2) {
            h1 = (h1 == null ? headB : h1.next);
            h2 = (h2 == null ? headA : h2.next);
        }
        return h1;
    }
}
