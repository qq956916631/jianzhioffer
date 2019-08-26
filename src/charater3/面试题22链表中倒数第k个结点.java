package charater3;

/*
总结：
    为了找到倒数第k个结点，假设链表一共有n个结点，则需要走x = n-k+1次才能到达。
    为了只遍历一次链表。设置2个指针,第一个指针先走n-(x) = k-1次，然后再走x次就会到达结尾。
*/

import org.junit.Test;

public class 面试题22链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode firstPoint = dummyHead, secondPoint = dummyHead;
        for (int i = 0; i < k - 1; i++) {
            firstPoint = firstPoint.next;
            if (firstPoint.next == null) // 抵达了最后一个结点，说明k>n
                return null;
        }
        while (firstPoint.next != null) {
            firstPoint = firstPoint.next;
            secondPoint = secondPoint.next;
        }
        return secondPoint;
    }

    @Test
    public void test() {
        ListNode head = generateList(new int[]{1, 2, 3, 4, 5, 6});
        printList(head);
        ListNode retNode = FindKthToTail(head,7);
        System.out.println(retNode.val);
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

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


