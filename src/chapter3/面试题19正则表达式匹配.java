package chapter3;

import org.junit.Test;

public class 面试题19正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int strBegin, char[] pattern, int patternBegin) {
        if (strBegin == str.length && patternBegin == pattern.length)
                return true;
        if (strBegin != str.length && patternBegin == pattern.length)
            return false;

        boolean nextIsStar;   //判断后一个是否为*
        if (patternBegin + 1 < pattern.length && pattern[patternBegin + 1] == '*')
            nextIsStar = true;
        else
            nextIsStar = false;

        if (!nextIsStar) {
            if (strBegin == str.length) return false;
            if (pattern[patternBegin] == '.')
                return match(str, strBegin + 1, pattern, patternBegin + 1);
            else
                return str[strBegin] == pattern[patternBegin] ? match(str, strBegin + 1, pattern, patternBegin + 1) : false;
        } else {
            int point = strBegin;
            boolean res = match(str, strBegin, pattern, patternBegin + 2); // 匹配0个
            if (res)
                return true;
            while (point < str.length && isValid(str[point], pattern[patternBegin])) { //匹配多个，直到str[point]不能被匹配为止
                if (match(str, ++point, pattern, patternBegin + 2))
                    return true;
            }
            return false;
        }

    }

    private boolean isValid(char str, char pattern) {
        if (pattern == '.') return true;
        return str == pattern;
    }

    @Test
    public void test() {
        boolean match = match("".toCharArray(), "a*a*".toCharArray());
        System.out.println(match);
    }
}
