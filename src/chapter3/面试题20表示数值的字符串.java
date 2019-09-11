package chapter3;

import org.junit.Test;

public class 面试题20表示数值的字符串 {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        int index;
        if (str[0] != '.') {
            index = matchAC(str, 0); // 匹配A
            if (index == -1)
                return false;
            if (index == str.length) //已抵达最后
                return true;
            if (str[index] == '.') // 若有.则尝试匹配B
                index = matchB(str, index+1);
        } else { // 匹配.B
            index = matchB(str, 1);
        }
        if (index == str.length) return true; // 已抵达最后，匹配成功

        if (str[index] == 'e' || str[index] == 'E')   //尝试匹配[e|EC]
            index = matchAC(str, index + 1);

        return index == str.length;
    }

    private int matchB(char[] str, int begin) {
        if (begin>=str.length) return -1;
        while (begin < str.length && str[begin] >= '0' && str[begin] <= '9')
            begin++;
        return begin;
    }

    private int matchAC(char[] str, int begin) {
        if (begin>=str.length) return -1;
        if (str[begin] == '+' || str[begin] == '-')
            begin++;
        while (begin < str.length && str[begin] >= '0' && str[begin] <= '9')
            begin++;
        return begin;
    }

    @Test
    public void test() {
        System.out.println(isNumeric("+100".toCharArray()));
        System.out.println(isNumeric("5e2".toCharArray()));
        System.out.println(isNumeric("-123".toCharArray()));
        System.out.println(isNumeric("3.1415".toCharArray()));
        System.out.println(isNumeric("-1E-16".toCharArray()));
        System.out.println(isNumeric("12e".toCharArray()));
        System.out.println(isNumeric("1a3.14".toCharArray()));
        System.out.println(isNumeric("1.2.3".toCharArray()));
        System.out.println(isNumeric("+-5".toCharArray()));
        System.out.println(isNumeric("12e+5.4".toCharArray()));
    }
}
