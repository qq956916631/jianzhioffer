package chapter;


import org.junit.Test;

/*
题目：
    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
    每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
    但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

总结：加了个判断条件的深搜。
*/
public class 面试题13机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] isVisited = new boolean[rows][cols];
        return dfs(isVisited, 0, 0, threshold);
    }

    private int dfs(boolean[][] isVisited, int x, int y, int threshold) {
        if (x < 0 || x >= isVisited.length || y < 0 || y >= isVisited[0].length ||
                isVisited[x][y] || !judge(x, y, threshold))
            return 0;
        isVisited[x][y] = true;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0], newY = y + direction[i][1];
            count += dfs(isVisited, newX, newY, threshold);
        }
        return count;
    }

    private boolean judge(int x, int y, int threshold) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return threshold >= sum;
    }

    @Test
    public void test() {
        System.out.println(movingCount(1, 2, 2));
    }
}
