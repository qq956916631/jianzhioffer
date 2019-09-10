package charater5;

import org.junit.Test;
/*
总结：
    利用异或的性质，两个相同的数会抵消为0。
    这道题对数组中的每个数都异或到一处，最后的结果为两个只出现一次的数字异或的结果，通过其中一位1进行分成两组，
    每一组都含有1个只出现过一次的数字，且其它数字都出现过两次。
*/
public class 面试题56_1只出现一次的两个数字 {
    // num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int num = 0;
        for (int i = 0; i < array.length; i++)
            num ^= array[i];
        System.out.println(num);
        int flag = 1;
        while (num % 2 == 0) {
            num /= 2;
            flag <<= 1;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) != 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    @Test
    public void test() {
        int num1[] = new int[1], num2[] = new int[1];
        FindNumsAppearOnce(new int[]{2, 2, 1, 3, 1, 4, 5, 5, 6, 7, 6, 7}, num1, num2);
        System.out.println(num1[0] + "," + num2[0]);
    }

}
