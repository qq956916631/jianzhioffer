package charater5;

import org.junit.Test;

public class 面试题53_2e0至n减1中缺失的数字 {
    public int getLostNum(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid + 1 == arr[mid]) {
                if (mid == 0 || mid - 1 == arr[mid - 1])
                    return mid;
                right = mid - 1;
            } else if (mid == arr[mid])
                left = mid + 1;
            else
                return -1;
        }
        if (left == arr.length)
            return left;
        return -1;
    }

    @Test
    public void test() {
        int lostNum = getLostNum(new int[]{0, 1, 2, 3, 4, 5});
        System.out.println(lostNum);
    }
}
