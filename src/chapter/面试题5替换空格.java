package chapter;

import org.junit.Test;
/*
    题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
*/
//  总结：一般涉及到数组的合并、替换、插入，假如从前往后解决的效率太低，可以考虑从后往前入手。
public class 面试题5替换空格 {
    public String replaceSpace(StringBuffer str) {
        int count = 0, frontPoint = str.length() - 1, rearPoint;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ' ')
                count++;
        for (int i = 0; i < count; i++)
            str.append("  ");
        rearPoint = str.length() - 1;
        while (frontPoint >= 0) {
            if (str.charAt(frontPoint) == ' ') {
                str.setCharAt(rearPoint--, '0');
                str.setCharAt(rearPoint--, '2');
                str.setCharAt(rearPoint--, '%');
            } else
                str.setCharAt(rearPoint--, str.charAt(frontPoint));
            frontPoint--;
        }
        return str.toString();
    }

    @Test
    public void test() {
        String s = replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(s);
    }
}
