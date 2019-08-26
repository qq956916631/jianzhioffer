package charater4;

import org.junit.Test;

public class 面试题27二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        t3.left = t6; t3.right = t7;
        zx(t1);
        System.out.println();
        Mirror(t1);
        zx(t1);

    }

    private void zx(TreeNode treeNode) {
        if (treeNode == null)
            return;
        zx(treeNode.left);
        System.out.print(treeNode.val + " ");
        zx(treeNode.right);
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
