package chapter2;

import org.junit.Test;

//总结：普通的动态规划解法比较简单但是要O(N),而剑指offer上提供的这种解法只要O(logN)的时间。
public class 面试题10_1斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        int[][] matrix = getMatrix(n - 1);
        return matrix[0][0];
    }

    private int[][] getMatrix(int n) {
        int[][] matrix1 = new int[][]{{1, 1,}, {1, 0}};
        if (n <= 1)
            return matrix1;
        int[][] matrix2 = getMatrix(n / 2);
        if (n % 2 == 0)
            return matrixMultiply(matrix2, matrix2);
        else
            return matrixMultiply(matrixMultiply(matrix2, matrix2), matrix1);
    }

    private int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) { // 两矩阵相乘
        int[][] matrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < matrix[0].length; k++)
                    matrix[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        return matrix;
    }

    @Test
    public void test() {
        for (int i = 0; i <= 10; i++)
            System.out.println(Fibonacci(i));
    }

}
