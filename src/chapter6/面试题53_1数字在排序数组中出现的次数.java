package chapter6;

import org.junit.Test;

public class 面试题53_1数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int index = binarySearch(array, 0, array.length - 1, k);
        if (index == -1)
            return 0;
        return countNum(array, k, index);
    }

    private int countNum(int[] array, int k, int index) {
        int count = 1, leftPoint = index - 1, rightPoint = index + 1;
        while (leftPoint >= 0 && array[leftPoint--] == k)
            count++;
        while (rightPoint < array.length && array[rightPoint++] == k)
            count++;
        return count;
    }

    private int binarySearch(int[] array, int left, int right, int k) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == k)
                return mid;
            else if (array[mid] > k)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    @Test
    public void test() {
        System.out.println(GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0));
    }

}
