package charater5;

import org.junit.Test;

public class 面试题44数字序列中某一位数字 {
    public int getNthNum(int n) {
        int count = 1, pre = 0, cur = 10, point = 0, totalDigit = (cur - pre) * count;
        while (n >= totalDigit) {
            n -= totalDigit;
            pre = pre == 0 ? 10 : pre * 10;
            cur = cur * 10;
            point = pre;
            count++;
            totalDigit = (cur - pre) * count;
        }
        point += n / count; // 得到指向的数
        int nth = n % count;
        int res = 0;
        for (int i = 0; i < count - nth; i++) {
            res = point % 10;
            point /= 10;
        }
        return res;
    }

    @Test
    public void test() {
        for (int i = 180; i < 200; i++)
            System.out.println(getNthNum(i));
    }

}
