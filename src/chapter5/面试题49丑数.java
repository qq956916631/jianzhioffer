package chapter5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
    （1）丑数数组： 1
    乘以2的队列：2
    乘以3的队列：3
    乘以5的队列：5
    选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （2）丑数数组：1,2
    乘以2的队列：4
    乘以3的队列：3，6
    乘以5的队列：5，10
    选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （3）丑数数组：1,2,3
    乘以2的队列：4,6
    乘以3的队列：6,9
    乘以5的队列：5,10,15
    选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （4）丑数数组：1,2,3,4
    乘以2的队列：6，8
    乘以3的队列：6,9,12
    乘以5的队列：5,10,15,20
    选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
    （5）丑数数组：1,2,3,4,5
    乘以2的队列：6,8,10，
    乘以3的队列：6,9,12,15
    乘以5的队列：10,15,20,25
*/
public class 面试题49丑数 {
    public int GetUglyNumber_Solution(int index) {
        int uglyNum = 1, count = 0;
        ArrayList<Integer> uglyList = new ArrayList<>();
        Queue<Integer>[] queues = new LinkedList[3];
        for (int i = 0; i < 3; i++) {
            queues[i] = new LinkedList<>();
            queues[i].add(1);
        }
        int res = 0;
        do {
            ArrayList<Integer> minIndexs = new ArrayList<>();
            minIndexs.add(0);
            for (int i = 1; i <= 2; i++) {
                if (queues[i].peek().equals( queues[minIndexs.get(0)].peek()))
                    minIndexs.add(i);
                if (queues[i].peek() < queues[minIndexs.get(0)].peek()) {
                    minIndexs.clear();
                    minIndexs.add(i);
                }
            }

            for (int i = 0; i < minIndexs.size(); i++)
                res = queues[minIndexs.get(i)].poll();
            uglyList.add(res);
            count++;
            queues[0].add(res * 2);
            queues[1].add(res * 3);
            queues[2].add(res * 5);
        }
        while (count != index);
        System.out.println(uglyList);
        return res;
    }

    @Test
    public void test() {
        int res = GetUglyNumber_Solution(0);
        System.out.println(res);
    }
}
