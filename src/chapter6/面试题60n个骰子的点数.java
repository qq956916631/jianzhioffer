package chapter6;

import java.util.Scanner;

public class 面试题60n个骰子的点数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), sum = in.nextInt();
        long[][] dpArr = new long[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= sum; j++)
                dpArr[i][j] = -1;
        //  System.out.println(Arrays.deepToString(dpArr));
        long num = dp(n, sum, dpArr);
        //System.out.println(Arrays.deepToString(dpArr));
  //      System.out.println( num+","+new Double(Math.pow(6, n)).longValue());
        System.out.println(new Fraction(num, new Double(Math.pow(6, n)).longValue()));
    }
    /*
    private static long dfs(int cur, int curSum, int n, int sum) {
        if (cur == n) {
            if (curSum >= sum)
                return 1;
            else
                return 0;
        }
        long res = 0;
        for (int i = 1; i <= 6; i++) {
            if (curSum + i + (n - cur - 1) * 6 < curSum)
                return 0;

            res += dfs(cur + 1, curSum + i, n, sum);
        }
        return res;
    }
    */

    // f(n,sum) =
    //              累加和i=1到6
    //              f(n-1,sum-i) sum-i>=1时
    //              f(n-1 ,1)    sum-i<1时
    private static long dp(int n, int sum, long[][] dpArr) {
        if (dpArr[n][sum] != -1)
            return dpArr[n][sum];
        if (n == 1) {
            if (sum > 6)
                dpArr[n][sum] = 0;
            else
                dpArr[n][sum] = 6 - sum + 1;
            return dpArr[n][sum];
        }
        dpArr[n][sum] = 0;
        for (int i = 1; i <= 6; i++) {
            if (sum - i >= 1)
                dpArr[n][sum] += dp(n - 1, sum - i, dpArr);
            else
                dpArr[n][sum] += dp(n - 1, 1, dpArr);
        }
        return dpArr[n][sum];
    }

    private static class Fraction {
        long fz, fm;

        public Fraction(long fz, long fm) {
            long x = gcd(fz, fm);
            this.fz = fz / x;
            this.fm = fm / x;
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public String toString() {
            if (fz == 1 && fm == 1)
                return "1";
            if (fz == 0)
                return "0";
            return fz + "/" + fm;
        }
    }
}
