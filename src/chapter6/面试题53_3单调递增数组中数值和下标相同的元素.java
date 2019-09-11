package chapter5;

import org.junit.Test;

public class 面试题53_3单调递增数组中数值和下标相同的元素 {
    public int getNum(int[] array) {
        if (array == null || array.length == 0)
            return -1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == mid)
                return mid;
            else if (array[mid] < mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    @Test
    public void test() {
        int num = getNum(new int[]{-3, -1, 2, 3, 5});
        System.out.println(num);
    }
}
