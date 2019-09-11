package chapter5;

import org.junit.Test;

public class 面试题54二叉搜索树的第K大结点 {
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null)
            return null;
        TreeNode res = KthNode(pRoot.left, k);
        if (res != null)
            return res;
        count++;
        if (count == k)
            return pRoot;
        res = KthNode(pRoot.right, k);
        return res;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode res = KthNode(t1, 3);
        System.out.println(res.val);

    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
