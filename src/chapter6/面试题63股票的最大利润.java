package chapter6;

import org.junit.Test;

import java.util.Arrays;

public class 面试题63股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null && prices.length <= 1)
            return 0;
        int[] profit = new int[prices.length]; // profit表示当前卖出时的最大收益
        profit[0] = 0;
        for (int i = 1; i < profit.length; i++)
            profit[i] = profit[i - 1] + (prices[i] - prices[i - 1]) <= 0 ? 0 : profit[i - 1] + (prices[i] - prices[i - 1]);
        System.out.println(Arrays.toString(profit));
        int max = profit[0];
        for (int i = 1; i < profit.length; i++)
            if (max < profit[i])
                max = profit[i];
        return max;
    }

    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
    }
}
