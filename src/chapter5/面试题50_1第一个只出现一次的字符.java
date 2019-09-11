package chapter5;

import org.junit.Test;

import java.util.*;

public class 面试题50_1第一个只出现一次的字符 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer count;
            if ((count = map.get(c)) == null)
                map.put(c, 1);
            else
                map.put(c, count + 1);
        }
        for (int i = 0; i < str.length(); i++)
            if (map.get(str.charAt(i)) == 1)
                return i;
        return -1;
    }

    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("aaccdeff"));
    }
}
