package charater5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
/*
总结：
    可以用两个堆来实现，左堆是最大堆，右堆是最小堆，通过代码维护两个堆之间的size差值，注意特殊情况即可
*/

public class 面试题41数据流中的中位数 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    int size = 0; // 大小

    public void Insert(Integer num) {
        size++;
        if (minHeap.size() == 0) {
            minHeap.add(num);
            return;
        }
        if (size % 2 != 0) {
            int minInMaxHeap = maxHeap.peek();
            if (num < minInMaxHeap)
                minHeap.add(num);
            else {
                minInMaxHeap = maxHeap.poll(); // 右堆大小保持不变
                maxHeap.add(num);
                minHeap.add(minInMaxHeap); // 左堆大小+1
            }

        } else {
            int maxInMinHeap = minHeap.peek();
            if (num > maxInMinHeap)
                maxHeap.add(num);
            else {
                maxInMinHeap = minHeap.poll(); // 右堆大小保持不变
                minHeap.add(num);
                maxHeap.add(maxInMinHeap); // 左堆大小+1
            }
        }
    }

    public Double GetMedian() {
        return size % 2 == 0 ? (minHeap.peek() + maxHeap.peek()) / 2.0 : (double) minHeap.peek();
    }

    @Test
    public void test() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            // int k = i;
            al.add(k);
            System.out.println(al);
            Insert(k);
            System.out.println(GetMedian());
            System.out.println("------------");
        }
    }
}
