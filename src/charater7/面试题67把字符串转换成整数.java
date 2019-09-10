package charater7;

import org.junit.Test;

public class 面试题67把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int point = 0;
        boolean isPositive = true;
        if (str.charAt(0) == '+')
            point++;
        if (str.charAt(0) == '-') {
            point++;
            isPositive = false;
        }
        int res = 0;
        for (int i = point; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                res = res * 10 + str.charAt(i) - '0';
            else
                return 0;
        }
        if (!isPositive)
            return -res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("-2a47483647"));
    }
}
