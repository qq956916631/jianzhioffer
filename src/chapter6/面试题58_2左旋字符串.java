package chapter5;

import org.junit.Test;

public class 面试题58_2左旋字符串 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0)
            return str;
        if (n >= str.length())
            n %= str.length();
        char[] array = str.toCharArray();
        reverse(array, 0, str.length() - 1);
        reverse(array, 0, str.length() - 1 - n);
        reverse(array, str.length() - n, str.length() - 1);
        return new String(array);
    }

    private void reverse(char[] array, int begin, int end) {
        for (int i = begin, j = 0; i <= (end + begin) / 2; i++, j++) {
            char temp = array[i];
            array[i] = array[end - j];
            array[end - j] = temp;
        }
    }

    @Test
    public void test() {
        String res = LeftRotateString("", 3);
        System.out.println(res);
    }
}
