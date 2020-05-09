package com.newcode_offer.两个链表的第一个公共结点;

/**
 * @author KyrieXu
 * @since 2020/5/2 10:08
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 56, 4, 8, 9};
        int[] nums2 = new int[]{1,9,11,10,12,8};

        ListNode listNode = ConstructListNode(nums);
        ListNode listNode1 = ConstructListNode(nums2);
        ListNode listNode2 = FindFirstCommonNode(listNode1, listNode);
        printListNode(listNode2);
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp1 = pHead1,res=null;
        while (tmp1!=null){
            ListNode tmp2=pHead2;
            while (tmp2!=null){
                if (tmp1.val==tmp2.val){
                    res=tmp1;
                    res.next=null;
                    break;
                }
                tmp2=tmp2.next;
            }
            tmp1=tmp1.next;
        }
        return res;
    }

    private static void printListNode(ListNode listNode) {
        ListNode tmp = listNode;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    private static ListNode ConstructListNode(int[] nums) {
        ListNode node = new ListNode(nums[0]);
        ListNode tail = node;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = tail.next;
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
            tail.next = tmp;
        }
        return node;
    }
}
