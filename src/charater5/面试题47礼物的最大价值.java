package charater5;

import org.junit.Test;

import java.util.Arrays;

public class 面试题47礼物的最大价值 {
    public int getMaxValue(int[][] map) {
        int[][] dp = new int[map.length][map[0].length];
        // System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] = map[i][j] + Math.max(dp[i - 1][j], dp[i][j-1]);
                else if (i - 1 >= 0) // 最优解只能通过上方的元素得到
                    dp[i][j] = map[i][j] + dp[i - 1][j];
                else if (j - 1 >= 0)
                    dp[i][j] = map[i][j] + dp[i][j - 1];
                else
                    dp[i][j] = map[i][j];
                System.out.println(Arrays.deepToString(dp));
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                max = (dp[i][j] > max) ? dp[i][j] : max;
        return max;
    }

    @Test
    public void test() {
        int res = getMaxValue(new int[][]{{1, 10, 3, 8},
                {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}});
        System.out.println(res);
    }


}
