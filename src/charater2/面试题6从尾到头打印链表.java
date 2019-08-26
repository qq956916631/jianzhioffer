package charater2;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;

public class 面试题6从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(printListFromTailToHead(listNode.next));
        arrayList.add(listNode.val);
        return arrayList;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(-1), p = head; // 创建带头结点的链表
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ArrayList<Integer> arrayList = printListFromTailToHead(head.next);
        System.out.println(arrayList);
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
