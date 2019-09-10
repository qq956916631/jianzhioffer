package charater5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 面试题50_2字符流中第一个只出现一次的字符 {
    ArrayList<Character> arrayList = new ArrayList<>();
    HashMap<Character, Integer> map = new HashMap<>();
    int point = -1; // 指向第一个不重复字符

    //Insert one char from stringstream
    public void Insert(char ch) {
        arrayList.add(ch);
        Integer count;
        if ((count = map.get(ch)) == null)
            map.put(ch, 1);
        else
            map.put(ch, count + 1);
        updatePoint();
    }

    private void updatePoint() {
        if (point == -1) {
            point++;
            return;
        }
        while (point < arrayList.size() && map.get(arrayList.get(point)) > 1)
            point++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (point == -1 || point >= arrayList.size())
            return '#';
        return arrayList.get(point);
    }

    @Test
    public void test() {
        String str = "";
        for (int i = 0; i < str.length(); i++) {
            Insert(str.charAt(i));
            System.out.println(FirstAppearingOnce());
        }
    }
}
