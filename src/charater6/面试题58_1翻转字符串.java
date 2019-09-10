package charater5;

import org.junit.Test;

public class 面试题58_1翻转字符串 {

    public String ReverseSentence(String str) {
        if (str == null || onlyBlank(str))
            return str;

        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length - 1; i++)
            sb.append(arr[i] + " ");
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }

    private boolean onlyBlank(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != ' ')
                return false;
        return true;
    }

    @Test
    public void test() {
        System.out.println(ReverseSentence(null));
    }
}
