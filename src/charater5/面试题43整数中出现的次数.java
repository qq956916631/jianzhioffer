package charater5;

import org.junit.Test;

public class 面试题43整数中出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        count += (n / 100) * 20;
        n %= 100;
        int k = n / 10;
        if (k == 0)
            count += ((n % 10 >= 1) ? 1 : 0);
        else if (k == 1) {
            count += 1; // 1-9的1个数
            count += n % 10 + 1;
        }
        else {
            count += 11; // 1-20的1个数
            count += (n / 10 - 2) + ((n % 10 >= 1) ? 1 : 0);
        }
        return count;
    }

    @Test
    public void test() {
        for (int i = 0; i <= 111; i++) {
            System.out.println(i + "," + NumberOf1Between1AndN_Solution(i));
        }
    }
}
