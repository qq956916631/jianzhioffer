package chapter;

import org.junit.Test;

/*
题目：
    请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
    如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    例如
    a b t g
    c f c s
    j d e h
    矩阵中包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，
    因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
总结：若当前路径不可能构成目标路径，则应将当前所在的位置访问标记重置为false，以便其它的路径来访问。

*/
public class 面试题12矩阵中的路径 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] flag = new boolean[rows][cols];
        char[][] map = toTwoDimension(matrix, rows, cols); // 转成二维数组，不过要多开一个rows*cols的空间
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (map[i][j] == str[0]) {
                    if (dfs(map, flag, i, j, str, 0))
                        return true;
                }
        return false;
    }

    private boolean dfs(char[][] map, boolean[][] flag, int x, int y, char[] str, int point) {
        flag[x][y] = true; // 设置当前位置已访问
        if (map[x][y] != str[point]) { // 当前位置不在正确路径内
            flag[x][y] = false; // 将其还原
            return false;
        }
        if (point == str.length - 1) // 得到正确路径
            return true;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右
        for (int k = 0; k < 4; k++) {
            int newX = x + direction[k][0], newY = y + direction[k][1];
            if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && flag[newX][newY] == false)
                if (dfs(map, flag, newX, newY, str, point + 1))
                    return true;
        }
        flag[x][y] = false;
        return false;
    }


    private char[][] toTwoDimension(char[] matrix, int rows, int cols) {
        char[][] matrix2 = new char[rows][cols];
        for (int i = 0, count = 0; i < rows; i++)
            for (int j = 0; j < cols; j++, count++)
                matrix2[i][j] = matrix[count];
        return matrix2;
    }

    @Test
    public void test() {
        boolean b1 = hasPath(new char[]{'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'}, 3, 4, new char[]{'b', 'f', 'c', 'e'});
        boolean b2 = hasPath(new char[]{'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'}, 3, 4, new char[]{'a', 'b', 'f', 'b'});
        System.out.println(b1);
        System.out.println(b2);
    }
}
