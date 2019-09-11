package chapter2;

import org.junit.Test;

import java.util.Stack;

/*
总结：
    要遵循2个原则：
    1. s1不能在s2不为空的情况下讲数倒过去
    2. 一次性要倒完

*/
public class 面试题9_1用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty())   // 当stack2为空时，才将stack1的元素倒过去
            if (stack1.isEmpty())
                throw new RuntimeException("队列已经为空");
            else
                moveStack1toStack2();
        return stack2.pop();
    }

    private void moveStack1toStack2() {
        while (!stack1.isEmpty())   // 一次性倒完
            stack2.push(stack1.pop());
    }

    @Test
    public void test() {
        for (int i = 0; i < 5; i++)
            push(i);
        for (int i = 0; i < 6; i++)
            System.out.println(pop());
    }
}
