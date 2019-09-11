package chapter;
import org.junit.Test;
/*
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 * */
/*
总结：
    1.排序    时间复杂度O(NlogN)、空间复杂度O(1)
    2.哈希表  时间复杂度O(N)、空间复杂度O(N)
    3.题目条件非常特殊，n个数，且取值范围为[0,n-1],这样就会提示我们数组的值假如不重复，每一个值都会出现,且刚好值对应下标。
      所以该解法的核心思想应该将元素“放置”到其正确的位置上，并且在放置的过程中，尝试去发现重复。
      缺点是会改变原数组值的顺序。   时间复杂度O(N)、空间复杂度O(1)

*/
public class 面试题3_1数组中重复的数字 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int point = 0;  //point代表下标，表示处理当前元素，其中[0,point)的元素已经在正确位置
        while (point < length) { // 当point==length时，表示[0,point]的元素都处于正确的位置上，无重复，循环终结
            int num = numbers[point];
            if (num == point) //表示当前数字已在正确的位置
                point++;
            else { //表示当前数字没有在正确的位置
                if (num == numbers[num]) { // 正确的位置已有正确的元素，重复出现
                    duplication[0] = numbers[point];
                    return true;
                } else // 将num放到正确的位置中
                    swap(numbers, point, num);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    @Test
    public void Test() {
        int[] duplication = new int[1];
        boolean duplicate = duplicate(new int[]{}, 0, duplication);
        System.out.println(duplicate + "," + duplication[0]);
    }
}
