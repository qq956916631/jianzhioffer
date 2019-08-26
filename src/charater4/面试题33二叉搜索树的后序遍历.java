package charater4;

import org.junit.Test;

public class 面试题33二叉搜索树的后序遍历 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
        if (left >= right) return true;
        int point = verifySequence(sequence, left, right); // 返回的point指向第一个>=sequence[right]的数
        if (point == -1)
            return false;
        return VerifySquenceOfBST(sequence, left, point - 1) && VerifySquenceOfBST(sequence, point, right - 1);
    }

    private int verifySequence(int[] sequence, int left, int right) {
        int root = sequence[right];
        int point = left;
        while (sequence[point] < root)
            point++;
        int point2 = point;
        while (point2 <= right)
            if (sequence[point2++] < root)
                return -1;
        return point;
    }

    @Test
    public void test() {
        System.out.println(VerifySquenceOfBST(new int[]{2,1}));
    }
}
