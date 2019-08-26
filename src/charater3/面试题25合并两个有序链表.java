package charater3;

import org.junit.Test;

public class 面试题25合并两个有序链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode newNode = new ListNode(-1);
        if (list1.val > list2.val) {
            newNode.val = list2.val;
            newNode.next = Merge(list1, list2.next);
        } else {
            newNode.val = list1.val;
            newNode.next = Merge(list1.next, list2);
        }
        return newNode;
    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        while (list1 != null && list2 != null) {
            ListNode node = new ListNode(-1);
            if (list1.val < list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            } else {
                node.val = list2.val;
                list2 = list2.next;
            }
            cur.next = node;
            cur = cur.next;
        }
        if (list1 == null)
            cur.next = list2;
        else
            cur.next = list1;
        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode list1 = generateList(new int[]{1});
        ListNode list2 = generateList(new int[]{});
        ListNode newHead = Merge2(list1, list2);
        printList(newHead);
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
