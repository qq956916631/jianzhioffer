package chapter;

import org.junit.Test;
/*总结 这道题目在不要求不能改变数组的情况下，可以用上一题的解法直接得出，因为值不会超过下标
        并且这题是必定存在一个以上的重复数字。
        1.哈希表 时间复杂度O(N)空间复杂度O(N)
        2.通过判统计该数组符合某个取值范围的个数来判断：重复的数字是否出现在该取值范围内。
        通过二分的思想来划分取值范围即可，假如只需找到一个重复数字则只需判断一个范围即可。假如要找出全部重复数字，则需要两个范围都判断。
        时间复杂度O(NlogN)，空间复杂度O(1)
*/

public class 面试题3_2不修改数组找出重复数字 {
    public int duplicate(int numbers[]) { //数组的值的取值范围为[1,length-1]
        return getDuplication(numbers, 1, numbers.length - 1);
    }

    private int getDuplication(int numbers[], int low, int high) {
        if (low == high)
            return low;
        int mid = (low + high) / 2;
        if (countInRange(numbers, low, mid) > mid - low + 1)
            return getDuplication(numbers, low, mid);
        else
            return getDuplication(numbers, mid + 1, high);

    }
    /*
    本人的错误做法，统计的个数小于区间长度，不代表不存在重复的数字。
    private List<Integer> getDuplication(int numbers[], int low, int high) {
        if (low == high) {
            List<Integer> list = new ArrayList<>();
            list.add(low);
            return list;
        }
        int mid = (low + high) / 2;
        List<Integer> list = new ArrayList<>();
        if (countInRange(numbers, low, mid) > mid - low + 1)
            list.addAll(getDuplication(numbers, low, mid));
        if (countInRange(numbers, mid + 1, high) > high - mid)
            list.addAll(getDuplication(numbers, mid + 1, high));
        return list;
    }
    */

    private int countInRange(int[] numbers, int low, int high) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] >= low && numbers[i] <= high)
                count++;
        return count;
    }

    @Test
    public void test() {
        int duplicate = duplicate(new int[]{1, 3, 5, 4, 3, 2, 6});
        System.out.println(duplicate);
    }
}
