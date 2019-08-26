package charater2;

import org.junit.Test;

/*
题目：
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
public class 面试题11旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int point1 = 0, point2 = array.length - 1;
        if (array[point1] < array[point2])  // 将0个元素旋转到后面的情况
            return array[point1];
        while (point1 + 1 != point2) {
            int mid = (point1 + point2) / 2;
            if (array[point1] == array[mid] && array[point2] == array[mid])
                return searchMin(array);
            if (array[point1] > array[mid])
                point2 = mid;
            else
                point1 = mid;
        }
        return array[point2];
    }

    private int searchMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < min)
                min = array[i];
        return min;
    }

    @Test
    public void test() {
        int min = minNumberInRotateArray(new int[]{2, 2, 2, 0, 2});
        System.out.println(min);
    }
}
