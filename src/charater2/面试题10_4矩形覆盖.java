package charater2;

import org.junit.Test;

public class 面试题10_4矩形覆盖 {
    int[] temp = new int[100];

    public int RectCover(int target) {
        if (target == 1 || target == 2)
            return target;
        if (temp[target] == 0)
            temp[target] = RectCover(target - 1) + RectCover(target - 2);
        return temp[target];
    }

    @Test
    public void test() {
        for (int i = 1; i <= 10; i++)
            System.out.println(RectCover(i));
    }
}
