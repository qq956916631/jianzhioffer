package chapter5;

import org.junit.Test;

import java.util.ArrayList;

public class 面试题57_1和为s的数字 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0)
            return res;
        int leftPoint = 0, rightPoint = array.length - 1;
        while (leftPoint <= rightPoint) {
            if ((array[leftPoint] + array[rightPoint]) == sum) {
                if (res.size() == 0) {
                    res.add(array[leftPoint]);
                    res.add(array[rightPoint]);
                } else {
                    if ((array[leftPoint] * array[rightPoint]) < (res.get(0) * res.get(1))) {
                        res.clear();
                        res.add(array[leftPoint]);
                        res.add(array[rightPoint]);
                    }
                }
                leftPoint++;
                rightPoint--;
            } else if ((array[leftPoint] + array[rightPoint]) < sum)
                leftPoint++;
            else
                rightPoint--;
        }
        return res;
    }

    @Test
    public void test() {
        ArrayList<Integer> res = FindNumbersWithSum(new int[]{1, 2, 3, 4, 5, 6}, 7);
        System.out.println(res);
    }
}
