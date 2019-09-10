package charater5;

import org.junit.Test;

import java.util.Random;

public class 面试题39数组中出现次数超过数组长度一半 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int num = findNth(array, 0, array.length - 1, array.length / 2);
        return countNum(array, num) * 2 > array.length ? num : 0;
    }

    private int countNum(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] == num)
                count++;
        return count;
    }

    private int findNth(int[] arr, int begin, int end, int n) {
        int randomIndex = begin + new Random().nextInt(end - begin + 1);
        swap(arr, randomIndex, end);
        int k = partition(arr, begin, end);
        if (k == n)
            return arr[k];
        else if (k > n)
            return findNth(arr, begin, k - 1, n);
        else
            return findNth(arr, k + 1, end, n);
    }

    private int partition(int[] arr, int begin, int end) {
        int key = arr[end];
        int leftPoint = begin, rightPoint = end; // arr[rightPoint]挖空
        while (true) {
            while (leftPoint < rightPoint && arr[leftPoint] <= key) leftPoint++;
            if (leftPoint == rightPoint)
                break;
            arr[rightPoint--] = arr[leftPoint]; // arr[leftPoint]挖空
            while (leftPoint < rightPoint && arr[rightPoint] >= key) rightPoint--;
            if (leftPoint == rightPoint)
                break;
            arr[leftPoint++] = arr[rightPoint];
        }
        arr[leftPoint] = key;
        return leftPoint;
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    @Test
    public void test() {
        int num = MoreThanHalfNum_Solution(new int[]{1, 1, 3, 4, 3});
        System.out.println(num);
    }
}
