package com.newcode_offer.复杂链表的复制;

/**
 * @author KyrieXu
 * @since 2020/4/24 8:54
 **/
public class Main {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        RandomListNode head = pHead;
        // 将新节点插入原来的节点后面
        // 原来的顺序是： A->B->C
        // 那么新的顺序是： A->A'->B->B'->C->C'
        while (head != null) {
            // 尾插法，插入节点
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = pHead;
        while (head != null) {
            RandomListNode node = head.next;
            if (head.random != null)
                // 这个语句根据上面的链表的顺序来推
                node.random = head.random.next;
            head = node.next;
        }
        head = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (head != null) {
            RandomListNode cloneNode = head.next;
            head.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            head = head.next;
        }
        return pCloneHead;
    }


}
