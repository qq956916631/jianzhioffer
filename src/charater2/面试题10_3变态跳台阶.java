package charater2;

import org.junit.Test;

public class 面试题10_3变态跳台阶 {
    int[] temp = new int[100];

    public int JumpFloorII(int target) {
        if (target == 1 || target == 2)
            return target;
        if (temp[target] == 0) {
            temp[target] = 1;   // 直接跳N阶
            for (int i = 1; i < target; i++)
                temp[target] += JumpFloorII(target - i);
        }

        return temp[target];
    }

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++)
            System.out.println(JumpFloorII(i));
    }
}
