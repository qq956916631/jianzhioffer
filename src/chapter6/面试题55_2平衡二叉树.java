package chapter5;

public class 面试题55_2平衡二叉树 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalanced(root).isBalance;
    }

    public Result isBalanced(TreeNode root) {
        if (root == null)
            return new Result(0, true);
        Result r1 = isBalanced(root.left);
        if (!r1.isBalance)
            return r1;
        Result r2 = isBalanced(root.right);
        if (!r2.isBalance)
            return r2;
        return new Result(Math.max(r1.height, r2.height) + 1, Math.abs(r1.height - r2.height) > 1 ? false : true);
    }

    private class Result {
        int height;
        boolean isBalance;

        public Result(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
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
