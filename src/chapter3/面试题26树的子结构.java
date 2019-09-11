package chapter3;

import org.junit.Test;

public class 面试题26树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        if (isEquals(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2))
            return true;
        return false;
    }

    private boolean isEquals(TreeNode root1, TreeNode root2) { // 判断2棵树是否相等。其结果有3部分组成：1.根必须相等 2.左子树必须相等 3.右子树必须相等
        if (root2 == null) // 递归边界
            return true;
        if (root1 == null)
            return false;
        if (root1.val == root2.val&&isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right))
            return true;
        return false;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t6;
        t5.right = t7;

        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(9);
        TreeNode r3 = new TreeNode(2);
        r1.left = r2;
        r1.right = r3;
        System.out.println(HasSubtree(t1, r1));
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
