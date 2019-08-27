package charater4;

import org.junit.Test;

/*
总结：
    1. 复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
    2. 遍历链表，A1->random = A->random->next;
    3. 将链表拆分成原链表和复制后的链表
*/
public class 面试题35复杂链表的复制 {
    public RandomListNode Clone(RandomListNode head) {
        if (head == null)
            return null;
        // 第1步
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }
        // 第2步
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        printList(head);
        // 第3步
        p = head;
        RandomListNode res = p.next;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = copy.next;
            if (copy.next != null)
                copy.next = copy.next.next;
            p = p.next;
        }
        return res;
    }

    @Test
    public void test() {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n2.random = n1;
        n3.random = n4;
        n4.random = n5;
        printList(n1);
        RandomListNode res = Clone(n1);
        printList(res);
        printList(n1);
    }

    private void printList(RandomListNode head) {
        while (head != null) {
            System.out.print(head+" ");
            head = head.next;
        }
        System.out.println();
    }

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label + "(" + (random == null ? "null" : random.label) + ")";
        }
    }
}
