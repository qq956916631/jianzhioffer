package chapter3;

import org.junit.Test;

public class 面试题18_2删除重复的结点 {
    public ListNode deleteDuplication(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        while (cur != null) {
            ListNode p = cur.next;
            boolean flag = false;
            while (p != null && p.val == cur.val) {
                p = p.next;
                flag = true;
            }
            if (flag) // cur指向的结点存在重复结点，则删除全部重复节点
                pre.next = p;
            else    // cur指向的结点不存在重复结点
                pre = pre.next;
            cur = p;
        }
        return dummyHead.next;
    }

    public ListNode deleteDuplication2(ListNode head) { //使用递归解决
        if (head == null)
            return null;
        ListNode p = head.next;
        boolean hasDuplication = false;
        while (p != null && p.val == head.val) {
            p = p.next;
            hasDuplication = true;
        }
        ListNode res = deleteDuplication(p);
        if (hasDuplication)
            return res;
        head.next = res;
        return head;
    }

    @Test
    public void test() {
        ListNode listNode = generateList(new int[]{1, 2, 2, 3, 4});
        printList(listNode);
        ListNode listNode2 = deleteDuplication2(listNode);
        printList(listNode2);
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
