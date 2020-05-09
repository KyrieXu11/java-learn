package com.newcode_offer.链表中倒数第k个结点;

/**
 * @author KyrieXu
 * @since 2020/4/10 9:30
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 **/
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        ListNode listNode1 = FindKthToTail1(listNode, 1);
        System.out.println(listNode1.val);
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode listNode = reverseListNode(head);
        int cnt=0;
        while (listNode!=null){
            if (cnt==k-1)
                return listNode;
            cnt++;
            listNode=listNode.next;
        }
        return null;
    }

    private static ListNode reverseListNode(ListNode listNode) {
       ListNode newNode = null;
       ListNode headNode = listNode;
       while (headNode!=null){
           // 保存下一个节点的指针
           ListNode tmpNode;
           tmpNode=headNode.next;
           headNode.next=newNode;
           newNode=headNode;
           headNode=tmpNode;
       }
       return newNode;
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode FindKthToTail1(ListNode head,int k) {
       int length = 0,cnt=0;
       ListNode listNode = head;
       while (listNode!=null){
           length++;
           listNode=listNode.next;
       }
       if (k>length)
           return null;
       listNode=head;
       while (listNode!=null){
           if (cnt<length-k)
               cnt++;
           else
               return listNode;
           listNode=listNode.next;
       }
       return null;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}