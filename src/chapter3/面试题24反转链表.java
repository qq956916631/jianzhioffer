package chapter3;

import org.junit.Test;

public class 面试题24反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode hasReversedList = head, noReversedList = head.next;
        hasReversedList.next = null;
        while (noReversedList != null) {  // 每一次进入循环前，都保证了hasReversedList指向已经反转后的链表的头节点，noReversedList则指向未反转链表的头节点
            ListNode temp = noReversedList.next; // 暂存，防止信息丢失
            noReversedList.next = hasReversedList;
            hasReversedList = noReversedList;
            noReversedList = temp;
        }
        return hasReversedList;
    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode newTail = head.next;
        ListNode newHead = ReverseList2(head.next);
        head.next = null;
        newTail.next = head;
        return newHead;
    }


    @Test
    public void test() {
        ListNode head = generateList(new int[]{1, 2, 3, 4, 5});
        printList(head);
        ListNode newhead = ReverseList2(head);
        printList(newhead);
    }

    private ListNode generateList(int[] arr) {
        ListNode head = new ListNode(-1), tail = head;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
