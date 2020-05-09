package com.newcode_offer.合并两个排序的链表;

/**
 * @author KyrieXu
 * @since 2020/4/10 12:45
 **/
public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(0);
        listNode2.next = new ListNode(1);
        listNode2.next.next = new ListNode(2);
        listNode2.next.next.next = new ListNode(3);
        listNode2.next.next.next.next = new ListNode(4);
        listNode2.next.next.next.next.next = new ListNode(5);

        ListNode merge = Merge(listNode1, listNode2);
        while (merge != null) {
            System.out.println(merge.val);
            merge=merge.next;
        }


    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);
        ListNode l1 = list1, l2 = list2;
        ListNode newNodeTail = newNode;
        newNodeTail.next=null;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                ListNode l1Next = l1.next;
                l1.next=newNodeTail.next;
                newNodeTail.next=l1;
                l1=l1Next;
                newNodeTail = newNodeTail.next;
            }else {
                ListNode l2Next = l2.next;
                l2.next=newNodeTail.next;
                newNodeTail.next=l2;
                l2=l2Next;
                newNodeTail = newNodeTail.next;
            }
        }
        while (l1!=null){
            ListNode l1Next = l1.next;
            l1.next=newNodeTail.next;
            newNodeTail.next=l1;
            l1=l1Next;
            newNodeTail = newNodeTail.next;
        }
        while (l2!=null){
            ListNode l2Next = l2.next;
            l2.next=newNodeTail.next;
            newNodeTail.next=l2;
            l2=l2Next;
            newNodeTail = newNodeTail.next;
        }
        return newNode.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}