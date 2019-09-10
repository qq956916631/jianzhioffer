package charater5;

import org.junit.Test;

import java.util.ArrayList;

public class 面试题46把数字翻译为字符串 {
    char[] translationList = new char[26];

    {
        for (int i = 0; i < 26; i++)
            translationList[i] = (char) ('a' + i);
    }

    public ArrayList<String> translateNumToString(int num) {
        int digitNum = 0, k = num;
        while (k != 0) {
            digitNum++;
            k /= 10;
        }
        ArrayList<String> resList = new ArrayList();
        translateNumToString(num, digitNum, new StringBuffer(""), resList);
        return resList;
    }

    private void translateNumToString(int num, int point, StringBuffer sb, ArrayList<String> resList) {
        if (point == 0) {
            resList.add(sb.reverse().toString());
            sb.reverse();
            return;
        }
        sb.append(translationList[num % 10]);
        translateNumToString(num / 10, point - 1, sb, resList);
        sb.deleteCharAt(sb.length() - 1);
        if (point > 1) {
            int index = (num % 10 + (num / 10 % 10) * 10);
            if (index <= 25) {
                sb.append(translationList[index]);
                translateNumToString(num / 100, point - 2, sb, resList);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        ArrayList<String> resList = translateNumToString(12258);
        System.out.println(resList);
    }
}
