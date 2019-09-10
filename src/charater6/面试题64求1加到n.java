package charater6;

public class 面试题64求1加到n {

    public int Sum_Solution(int n) {
        int ans = n;
        boolean temp = ans > 0 && (ans += Sum_Solution(n - 1)) > 0;
        return ans;
    }
}
