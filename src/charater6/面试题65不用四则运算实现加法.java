package charater6;

import org.junit.Test;

import java.util.Random;
import java.util.Stack;

public class 面试题65不用四则运算实现加法 {
    public int Add(int num1, int num2) {
        int flag = 0, res = 0, cur = 1, target = 1 << 31; // flag表示进位,res为相加结果
        while (cur != target) {
            int a = (num1 & cur) == 0 ? 0 : 1, b = (num2 & cur) == 0 ? 0 : 1;
            if ((a ^ b ^ flag) == 1)
                res |= cur;
            //判断是否进位
            if ((a % 2 == 1 && b % 2 == 1) || (((a ^ b) == 1) && flag == 1))
                flag = 1;
            else
                flag = 0;

            cur <<= 1;
        }
        int a = (num1 & cur) == 0 ? 0 : 1, b = (num2 & cur) == 0 ? 0 : 1;
        if ((a ^ b ^ flag) == 1)
            res |= cur;
        return res;
    }

    @Test
    public void test() {
        for (int i = 0; i < 200; i++) {
            int a = 0, b = -101;
            System.out.println(a + "+" + b + "=" + (a + b) + "," + Add(a, b));
        }

    }
}
