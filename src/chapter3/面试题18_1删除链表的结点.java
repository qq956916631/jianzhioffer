package chapter3;

import org.junit.Test;

/*
    通过使用后一个节点的值覆盖前一个节点的值，然后删除后一个结点。
*/
public class 面试题18_1删除链表的结点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }

    @Test
    public void test() {
        ListNode listNode = generateList(new int[]{1, 2, 3, 4, 5});
        printList(listNode);
        deleteNode(listNode.next.next.next);
        printList(listNode);

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    ListNode generateList(int[] arr) {
        ListNode head = new ListNode(-1), tail = head;
        for (int i = 0; i < arr.length; i++) {
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head.next;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
