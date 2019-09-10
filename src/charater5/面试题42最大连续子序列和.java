package charater5;

import org.junit.Test;

import java.util.Arrays;
/*
总结：
    dp[i]表示的语义是当前选择了i的最大和
* */
public class 面试题42最大连续子序列和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] < 0 ? array[i] : dp[i - 1] + array[i];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++)
            if (dp[i] > max)
                max = dp[i];
        System.out.println(Arrays.toString(dp));
        return max;
    }

    @Test
    public void test() {
        System.out.println(FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
    }
}
