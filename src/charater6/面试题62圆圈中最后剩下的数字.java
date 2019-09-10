package charater6;

import org.junit.Test;

import java.util.Arrays;

public class 面试题62圆圈中最后剩下的数字 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        int point = 0; // point总指向报数为0的小朋友
        while (n != 1) {
            point = (point + m - 1) % n;
            // System.out.println(Arrays.toString(arr));
            for (int i = point; i < arr.length - 1; i++)
                arr[i] = arr[i + 1];
            n--;
        }
        return arr[0];
    }


    public int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        ListNode dummyHead = new ListNode(-1), tail = dummyHead;
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        ListNode head = dummyHead.next;
        tail.next = head;
        ListNode pre = tail, cur = head;
        while (n != 1) {
            printList(cur,n);
            for (int i = 0; i < m - 1; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = cur.next;
            cur = cur.next;
            n--;

        }
        return pre.val;
    }

    private void printList(ListNode head, int n) {
        while (n > 0) {
            System.out.print(head.val + "-->");
            head = head.next;
            n--;
        }
        System.out.println();
    }

    @Test
    public void test() {
        System.out.println(LastRemaining_Solution2(8, 5));
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }
    }
}
