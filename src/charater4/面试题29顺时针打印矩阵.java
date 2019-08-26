package charater4;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import org.junit.Test;

import java.util.ArrayList;

public class 面试题29顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        return printMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private ArrayList<Integer> printMatrix(int[][] matrix, int leftX, int leftY, int rightX, int rightY) {
        if (leftX > rightX || leftY > rightY)
            return new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList();
        int x = leftX, y = leftY - 1;
        if (leftX == rightX)   // 只有一行的情况
            while (y < rightY) arrayList.add(matrix[x][++y]);
        else if (leftY == rightY) { // 只有一列的情况
            x = leftX - 1;
            y = leftY;
            while (x < rightX) arrayList.add(matrix[++x][y]);
        } else {
            while (y < rightY) arrayList.add(matrix[x][++y]); //向右移动
            while (x < rightX) arrayList.add(matrix[++x][y]); //向下移动
            while (y > leftY) arrayList.add(matrix[x][--y]); // 向左移动
            while (x > leftX + 1) arrayList.add(matrix[--x][y]); // 像上移动
        }
        arrayList.addAll(printMatrix(matrix, leftX + 1, leftY + 1, rightX - 1, rightY - 1));
        return arrayList;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1}, {5}, {9}, {13}};
        ArrayList<Integer> arrayList = printMatrix(matrix);
        System.out.println(arrayList);
    }
}
