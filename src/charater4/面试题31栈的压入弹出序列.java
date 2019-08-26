package charater4;

import org.junit.Test;

import java.util.Stack;
/*
总结：
    当栈顶的元素不是弹出序列的当前元素，就压栈。反之如果栈顶元素是弹出序列的当前元素的话，就出栈
*/
public class 面试题31栈的压入弹出序列 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushPoint = 0, popPoint = 0;
        while (pushPoint != pushA.length) {
            if (pushA[pushPoint] == popA[popPoint]) {
                pushPoint++;
                popPoint++;
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == popA[popPoint]) {
                stack.pop();
                popPoint++;
            } else
                stack.push(pushA[pushPoint++]);
        }
        while (!stack.isEmpty())
            if (stack.pop() != popA[popPoint++])
                return false;
        return true;
    }

    @Test
    public void test(){
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
