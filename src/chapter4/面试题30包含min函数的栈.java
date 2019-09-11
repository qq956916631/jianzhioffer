package chapter4;

import org.junit.Test;

import java.util.Stack;

public class 面试题30包含min函数的栈 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty())
            minStack.push(node);
        else {
            int min = min();
            if (node < min)
                minStack.push(node);
            else
                minStack.push(min);
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty())
            throw new RuntimeException("栈已为空");
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            throw new RuntimeException("栈已为空");
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty())
            throw new RuntimeException("栈已为空");
        return minStack.peek();
    }

    @Test
    public void test() {
        for (int i = 5; i> 0; i--)
            push(i);
        for (int i = 0; i < 5; i++) {
            System.out.println(min());
            pop();
        }
    }
}
