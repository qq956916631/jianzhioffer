package charater5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 面试题45把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        ArrayList<MyNumber> arrayList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            arrayList.add(new MyNumber(numbers[i]));
        Collections.sort(arrayList, new Comparator<MyNumber>() {
            @Override
            public int compare(MyNumber o1, MyNumber o2) {
                return compare(o1, 0, o2, 0);
            }

            private int compare(MyNumber o1, int point1, MyNumber o2, int point2) {
                if (point1 == o1.str.length() - 1 && point2 == o2.str.length() - 1)
                    return o1.str.charAt(point1) - o2.str.charAt(point2);
                // 谁到达结尾谁的指针不用动
                if (o1.str.charAt(point1) == o2.str.charAt(point2))
                    return point1 == o1.str.length() - 1 ? compare(o1, point1, o2, point2 + 1) : compare(o1, point1 + 1, o2, point2);
                else
                    return o1.str.charAt(point1) - o2.str.charAt(point2);
            }
        });
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numbers.length; i++)
            sb.append(arrayList.get(i).str);
        return sb.toString();
    }

    @Test
    public void test() {
        String res = PrintMinNumber(new int[]{1, 12, 11});
        System.out.println(res);
    }

    private class MyNumber {
        String str;

        MyNumber(int number) {
            str = new String(number + "");
        }
    }


}
