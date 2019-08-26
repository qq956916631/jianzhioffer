package charater2;

import org.junit.Test;

public class 面试题10_2青蛙跳台阶 {
    int[] temp = new int[100];

    public int JumpFloor(int target) {
        if (target == 1 || target == 2)
            return target;
        if (temp[target] == 0)
            temp[target] = JumpFloor(target - 1) + JumpFloor(target - 2);
        return temp[target];
    }

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++)
            System.out.println(JumpFloor(i));
    }
}
