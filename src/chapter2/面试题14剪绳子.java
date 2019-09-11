package chapter2;

import org.junit.Test;

/*总结：
    动态规划：n<=3时，剪掉绳子的收益没有不剪掉的收益高。当n>=5时，剪绳子的收益比不剪绳子更大。

    贪心：每次尽可能多的剪长度为3的绳子。因为3*(n-3)>2*(n-2)>n，并且总能分解成剪成长度为2、3、4的长度
    */
public class 面试题14剪绳子 {

    // 动态规划
    public int maxMultiplyLine1(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max)
                    max = temp;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int maxMultiplyLine2(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int timeOf3 = n / 3;
        if ((n - (timeOf3 - 1) * 3) == 4)
            timeOf3--;
        int tiemOf2 = (n - timeOf3 * 3) / 2;
        return (int)(Math.pow(3, timeOf3) * Math.pow(2, tiemOf2));
    }

    @Test
    public void test() {
        for (int i = 0; i <= 10; i++)
            System.out.println(maxMultiplyLine1(i) + " " + maxMultiplyLine2(i));
    }
}
