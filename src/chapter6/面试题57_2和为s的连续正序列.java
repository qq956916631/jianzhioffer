package chapter5;

import org.junit.Test;

import java.util.ArrayList;

public class 面试题57_2和为s的连续正序列 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (sum == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(1);
            resList.add(res);
            return resList;
        }
        int leftPoint = 1, rightPoint = 2;
        while (rightPoint < sum && leftPoint <= rightPoint) {
            int temp = (leftPoint + rightPoint) * (rightPoint - leftPoint + 1) / 2;
            if (sum == temp) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = leftPoint; i <= rightPoint; i++)
                    res.add(i);
                resList.add(res);
                leftPoint++;
                rightPoint++;
            } else if (sum < temp)
                leftPoint++;
            else
                rightPoint++;
        }
        return resList;
    }

    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(0);
        System.out.println(arrayLists);
    }
}
