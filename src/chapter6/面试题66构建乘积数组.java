package chapter6;

import org.junit.Test;

import java.util.Arrays;

public class 面试题66构建乘积数组 {
    public int[] multiply(int[] A) {
        if (A == null) return null;
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++)
            B[i] = 1;
        // 处理下三角
        for (int i = 1; i < B.length; i++)
            for (int j = 0; j < i; j++)
                B[i] *= A[j];
        for (int i = 1; i < B.length; i++)
            for (int j = 0; j < i; j++)
                B[B.length - 1 - i] *= A[B.length - 1 - j];
        return B;
    }

    @Test
    public void test() {
        int[] res = multiply(new int[]{1});
        System.out.println(Arrays.toString(res));
    }
}
