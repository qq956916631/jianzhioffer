package charater4;

import java.util.ArrayList;
import java.util.Scanner;

public class 面试题38_3八皇后 {
    public static void main(String[] args) {
        boolean[][] map = new boolean[8][8];
        int[] res = new int[8];
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        generateRes(map, 0, res, resList);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int x : resList.get(n - 1))
                System.out.print(x);
            System.out.println();
        }
    }

    private static void generateRes(boolean[][] map, int x, int[] res, ArrayList<ArrayList<Integer>> resList) {
        if (x == 8) {
            ArrayList al = new ArrayList();
            for (int i = 0; i < 8; i++)
                al.add(res[i]);
            resList.add(al);
            return;
        }
        for (int i = 0; i < 8; i++) {
            map[x][i] = true;
            if (isValid(map, x, i)) {
                res[x] = i + 1;
                generateRes(map, x + 1, res, resList);
            }
            map[x][i] = false;
        }
    }

    private static boolean isValid(boolean[][] map, int x, int y) {
        for (int i = 0; i < x; i++) // 判断同一列
            if (map[i][y])
                return false;
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) // 判断左斜边
            if (map[i][j])
                return false;
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) // 判断右斜边
            if (map[i][j])
                return false;
        return true;
    }
}
