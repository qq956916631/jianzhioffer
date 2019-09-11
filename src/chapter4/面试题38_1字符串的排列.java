package chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 面试题38_1字符串的排列 {


    public ArrayList<String> Permutation(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        boolean[] isVisited = new boolean[arr.length];
        char[] ans = new char[arr.length];
        ArrayList<String> ansList = new ArrayList<>();
        Permutation(arr, isVisited, ans, 0, ansList);
        return ansList;
    }

    private void Permutation(char[] arr, boolean[] isVisited, char[] ans, int point, ArrayList<String> ansList) {
        if (point == ans.length) {
            String ansStr = new String(ans);
            if (!ansList.contains(ansStr))
                ansList.add(ansStr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!isVisited[i]) {
                ans[point] = arr[i];
                isVisited[i] = true;
                Permutation(arr, isVisited, ans, point + 1, ansList);
                isVisited[i] = false;
            }
        }
    }

    @Test
    public void test() {
        ArrayList<String> ansList = Permutation("abcde");
       System.out.println(ansList);
    }
}
