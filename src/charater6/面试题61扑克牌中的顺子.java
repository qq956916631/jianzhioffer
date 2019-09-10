package charater6;

import org.junit.Test;

public class 面试题61扑克牌中的顺子 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5)
            return false;
        int[] visited = new int[14];
        int count = 0; //记录大小王个数
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                count++;
            else
                visited[numbers[i]] = 1;
        }
        if (count == 0)
            return judge(visited);
        return fun(count, visited);
    }

    private boolean fun(int count, int[] visited) {
        if (count == 0)
            return judge(visited);
        for (int i = 0; i < visited.length; i++)
            if (visited[i] == 0) {
                visited[i] = 1;
                if (fun(count - 1, visited))
                    return true;
                visited[i] = 0;
            }
        return false;
    }

    private boolean judge(int[] visited) {
        int index = 0;
        while (visited[index] == 0)
            index++;
        for (int i = index + 1; i < index + 5; i++)
            if (visited[i] == 0)
                return false;
        return true;
    }

    @Test
    public void test() {
        System.out.println(isContinuous(new int[]{8, 0, 3, 0, 5}));
    }
}
