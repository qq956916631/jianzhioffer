package chapter5;

import org.junit.Test;

import java.util.*;

public class 面试题40最小的k个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        if (arr == null || arr.length <= 0 || arr.length < k || k < 1) {
            return al;
        }
        findNth(arr, 0, arr.length - 1, k - 1);
        for (int i = 0; i < k; i++)
            al.add(arr[i]);
        Collections.sort(al);
        return al;
    }

    private int findNth(int[] arr, int begin, int end, int n) {
        int randomIndex = begin + new Random().nextInt(end - begin + 1);
        swap(arr, randomIndex, end);
        int k = partition2(arr, begin, end);
        if (k == n)
            return arr[k];
        else if (k > n)
            return findNth(arr, begin, k - 1, n);
        else
            return findNth(arr, k + 1, end, n);
    }

    private int partition1(int[] arr, int begin, int end) {
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

    private int partition2(int[] arr, int begin, int end) {
        int leftPoint = begin, rightPoint = end, key = arr[end];
        while (leftPoint < rightPoint) { // 总是当leftPoint==rightPoint的时候跳出循环
            // while (leftPoint < rightPoint && arr[rightPoint] >= key) rightPoint--;
            // 假如这段放最前边，可能跳出循环时arr[rightPoint]<key，然后leftPoint==rightPoint结束，arr[rightPoint]和arr[end]交换，就会错误
            // arr[end]只接受大于等于它的数交换。

            // 每次进入循环前，rightPoint必定会指向一个>=key的数
            while (leftPoint < rightPoint && arr[leftPoint] <= key) leftPoint++;
            while (leftPoint < rightPoint && arr[rightPoint] >= key) rightPoint--;
            swap(arr, leftPoint, rightPoint);
        }
        swap(arr, rightPoint, end);
        return rightPoint;
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    @Test
    public void test() {
        for (int k = 0; k < 5; k++) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++)
                arr[i] = new Random().nextInt(20);
            System.out.println(Arrays.toString(arr));
            System.out.println(GetLeastNumbers_Solution(arr, 5));
            System.out.println(Arrays.toString(arr));
            System.out.println("-------");
        }
    }
}
