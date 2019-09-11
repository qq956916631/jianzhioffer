package chapter;

import org.junit.Test;

public class 面试题15二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1); //二进制表示中，最右边的1会被变为0
        }
        return count;
    }

    @Test
    public void test() {
        for (int i = 0; i <= 10; i++)
            System.out.println(NumberOf1(i));
    }
}
