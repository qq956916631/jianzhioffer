package charater5;

import org.junit.Test;

import java.util.Arrays;

public class 面试题56_2数组中唯一只出现一次的数字 {
    public int FindNumsAppearOnce(int[] array) {
        int[] arr = new int[32];
        for (int i = 0; i < array.length; i++) {
            int k = array[i], point = 0;
            while (k != 0) {
                if (k % 2 == 1)
                    arr[point]++;
                k /= 2;
                point++;
            }
        }
        System.out.println(Arrays.toString(arr));
        int res = 0;
        int base = 1;
        for (int i = 0; i < 32; i++) {
            if (arr[i] % 3 != 0)
                res += base;
            base *= 2;
        }
        return res;
    }

    @Test
    public void test() {
        int res = FindNumsAppearOnce(new int[]{2, 2, 3, 3, 3, 2, 55, 22, 22, 55, 22, 55, 9});
        System.out.println(res);
    }
}
