package charater5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 面试题59_1队列的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size)
            return arrayList;
        deque.addLast(0);
        if (0 >= size - 1)
            arrayList.add(num[deque.getFirst()]);
        for (int i = 1; i < num.length; i++) {
            int last = deque.getLast();
            while (last != -1 && num[last] <= num[i]) {
                deque.removeLast();
                last = deque.size() == 0 ? -1 : deque.getLast();
            }
            deque.addLast(i);
            // 删除无效下标
            int first = deque.getFirst();
            while (first < i + 1 - size) {
                deque.removeFirst();
                first = deque.getFirst();
            }
            if (i >= size - 1)
                arrayList.add(num[deque.getFirst()]);

        }
        return arrayList;
    }

    @Test
    public void test() {
        ArrayList<Integer> res = maxInWindows(new int[]{2,4,6}, 1);
        System.out.println(res);

    }
}
