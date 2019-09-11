package chapter3;

import org.junit.Test;

import java.util.Arrays;

public class 面试题21_1调整数组顺序使奇数在前偶数在后 {
    public void reOrderArray(int[] array) {
        reOrderArray(array,(arr, index) -> arr[index]%2==0);
    }
    public void reOrderArray(int[] array,Function f) {
        int leftPoint = 0, rightPoint = array.length - 1;
        while (true) {
            while (rightPoint >= 0 && f.fun(array,rightPoint)) // 循环结束后,rightPoint必定指向了奇数，或者指向下标变成-1
                rightPoint--;
            while (leftPoint < array.length && !f.fun(array,leftPoint)) //循环结束后,leftPoint必定指向了偶数，或者指向下标为length
                leftPoint++;
            if (leftPoint >= rightPoint) break;
            swap(array, leftPoint, rightPoint);
        }
    }
    private void swap(int[] array, int leftPoint, int rightPoint) {
        int temp = array[leftPoint];
        array[leftPoint] = array[rightPoint];
        array[rightPoint] = temp;
    }

    @Test
    public void test() {
        int arr[] = new int[]{1, 2, 3, 4, 5, 4, 5, 6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }


}

@FunctionalInterface
interface Function{
    boolean fun(int []arr,int index);
}