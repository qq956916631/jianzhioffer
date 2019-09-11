package chapter2;


import org.junit.Test;

/*
   问题描述：
   在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
   每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
/*总结：
    有序的性质总能带给查找操作好处，并且很多思路都是通过有序来剔除掉某个范围内的数，如二分查找会剔除一半范围；BST查找会剔除半边子树；
    这题也不例外，它也是通过有序性质通过剔除某部分的思想来解决的
*/
public class 面试题4_1二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        int beginRow = 0, beginColumn = array[0].length - 1;
        while (beginRow < array.length && beginColumn >= 0) {  // 当跑出边界时，循环终结，代表没有该数
            if (array[beginRow][beginColumn] < target)  // 排除当前位置同一行左边的数及当前的数，即向下移动一位
                beginRow++;
            else if (array[beginRow][beginColumn] > target) // 排除当前位置同一列下边的数及当前的数，即向左移动一位
                beginColumn--;
            else
                return true;
        }
        return false;
    }

    @Test
    public void test() {
        boolean find = Find(7, new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}});
        System.out.println(find);
    }
}
