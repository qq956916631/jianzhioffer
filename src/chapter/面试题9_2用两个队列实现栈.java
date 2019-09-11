package chapter;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 面试题9_2用两个队列实现栈 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int n) {
        queue1.add(n);
    }

    public int pop() {
        if (queue1.size() == 0)
            throw new RuntimeException("栈已为空");
        while (queue1.size() > 1)
            queue2.add(queue1.poll());
        int n = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return n;
    }

    @Test
    public void test() {
        for (int i = 0; i < 5; i++)
            push(i);
        for (int i = 0; i < 3; i++)
            System.out.println(pop());
        for (int i = 5; i < 10; i++)
            push(i);
        for (int i = 0; i < 6; i++)
            System.out.println(pop());
    }
}
