package chapter3;

import org.junit.Test;

public class 面试题17打印1到最大n位数 {
    public void print1(int n) { //解法1，通过自定义大数解决
        BigInteger bigInteger = new BigInteger(n);
        while (bigInteger.increment()) {
            bigInteger.print();
        }
    }

    public void print2(int n) {
        char[] arr = new char[n];
        print2(arr, 0);
    }

    private void print2(char[] arr, int point) {
        if (point == arr.length) {
            printBigInteger(arr);
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            arr[point] = i;
            print2(arr, point + 1);
        }
    }

    private void printBigInteger(char[] arr) {
        boolean flag = false; // 标记是否已经访问第1个非0数
        int point = 0;
        while (point < arr.length) {
            if (!flag) {
                if (arr[point] != '0') {
                    System.out.print(arr[point]);
                    flag = true;
                }
            } else
                System.out.print(arr[point]);
            point++;
        }
        System.out.println();
    }

    private class BigInteger {
        private char[] arr;

        public BigInteger(int n) {
            arr = new char[n + 1];
            for (int i = 0; i < n + 1; i++)
                arr[i] = '0';
        }

        public boolean increment() {
            int point = arr.length - 1;
            while (arr[point] == '9') {
                arr[point--] = '0';
            }
            if (point == 0)
                return false;
            arr[point]++;
            return true;
        }

        public void print() {
            boolean flag = false; // 标记是否已经访问第1个非0数
            int point = 0;
            while (point < arr.length) {
                if (!flag) {
                    if (arr[point] != '0') {
                        System.out.print(arr[point]);
                        flag = true;
                    }
                } else
                    System.out.print(arr[point]);
                point++;
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        print2(4);
    }
}
