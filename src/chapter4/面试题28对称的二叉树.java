package chapter4;

import org.junit.Test;

public class 面试题28对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right); // 若左右子树互为镜像，则该树对称
    }

    // 比较两棵树t1,t2是否互为镜像，由三部分组成：1.根结点相等，2.t1左子树与t2右子树互为镜像 3.t1右子树与t2左子树互为镜像
    boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val && isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left))
            return true;
        return false;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        System.out.println(isSymmetrical(t1));
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
