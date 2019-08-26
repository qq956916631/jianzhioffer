package charater3;

/*
设起点到相遇点距离为x，起点到入口点距离为y，环长度为r，则快慢针相遇时，满足2x-x=nr，n为快针在环中转的圈数。--> x=nr
快慢针相遇点距环入口点距离x-y
相遇后，快针从起点重新开始以步长为1速度开始走，经过距离y到达环入口点，慢针走y步后距离环入口点距离为x-y+y=x=nr，即走到了环入口点，两个指针相遇
*/
public class 面试题23链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slowPoint = dummyHead, fastPoint = dummyHead;
        do {
            slowPoint = slowPoint.next;
            if (fastPoint.next == null || fastPoint.next.next == null)
                return null;
            fastPoint = fastPoint.next;
            fastPoint = fastPoint.next;
        } while (slowPoint != fastPoint);
        slowPoint = dummyHead;
        while (slowPoint != fastPoint) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }
        return fastPoint;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
