package charater5;

import org.junit.Test;

public class 面试题51数组中的逆序对 {
    public int InversePairs(int[] array) {
        if (array == null) return 0;
        int[] temp = new int[array.length];
        return InversePairs(array, temp, 0, array.length - 1);
    }

    public int InversePairs(int[] array, int[] temp, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftCount = InversePairs(array, temp, left, mid);
        int rightCount = InversePairs(array, temp, mid + 1, right);
        int count = mergeAndCount(array, temp, left, right, mid);
        return (leftCount + rightCount + count) % 1000000007;
    }

    private int mergeAndCount(int[] array, int[] temp, int left, int right, int mid) {
        int point1 = mid, point2 = right, point3 = right, count = 0;
        while (point1 >= left && point2 >= mid + 1) {
            if (array[point1] > array[point2]) {
                count += (point2 - mid);
                count %= 1000000007;
                temp[point3--] = array[point1--];
            } else
                temp[point3--] = array[point2--];
        }
        while (point1 >= left)
            temp[point3--] = array[point1--];
        while (point2 >= mid + 1)
            temp[point3--] = array[point2--];
        for (int i = left; i <= right; i++)
            array[i] = temp[i];
        return count % 1000000007;
    }

    @Test
    public void test() {
        System.out.println(InversePairs(null));
    }
}
