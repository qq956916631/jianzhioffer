package chapter3;

import org.junit.Test;

import java.util.Arrays;

public class 面试题21_2保持稳定调整数组顺序 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1)
            return;
        for (int i = 1; i < array.length; i++) { // 每一次循环结束后，[0,i]都是奇数在前，偶数在后，且稳定
            if (array[i] % 2 != 0) {
                int index = i;
                while (index > 0 && array[index - 1] % 2 == 0) { //前一个是偶数
                    swap(array, index - 1, index);
                    index--;
                }
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Test
    public void test() {
        int arr[] = new int[]{3,1};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
