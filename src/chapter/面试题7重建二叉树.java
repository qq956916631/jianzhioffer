package chapter;

import org.junit.Test;

/*
题目：
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/
/*
总结：
    通过前序遍历序列的首个元素得到当前树的根，再通过中序遍历序列得出左右子树的长度，
    从而划分出左右子树的前序遍历序列和中序遍历序列，然后递归构造出左子树和右子树，最后合并到根，返回根。

    之所以能用递归，因为前序遍历序列包含了左子树的前序遍历序列和右子树的前序遍历序列（中序遍历序列同理），问题性质没有改变，只是规模改变，可用递归。
        */
public class 面试题7重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preLow, int preHigh, int[] in, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh)
            return null;
        if (preLow == preHigh)
            return new TreeNode(pre[preLow]);
        int rootIndex;
        for (rootIndex = inLow; in[rootIndex] != pre[preLow]; rootIndex++)
            ;
        int leftTreeLength = rootIndex - inLow;
        TreeNode treeNode = new TreeNode(pre[preLow]);
        treeNode.left = reConstructBinaryTree(pre, preLow + 1, preLow + leftTreeLength, in, inLow, inLow + leftTreeLength - 1);
        treeNode.right = reConstructBinaryTree(pre, preLow + leftTreeLength + 1, preHigh, in, rootIndex + 1, inHigh);
        return treeNode;
    }

    @Test
    public void test() {
        TreeNode treeNode = reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        qx(treeNode);
        System.out.println();
        zx(treeNode);
    }

    private void qx(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.print(treeNode.val + " ");
        qx(treeNode.left);
        qx(treeNode.right);
    }

    private void zx(TreeNode treeNode) {
        if (treeNode == null)
            return;
        zx(treeNode.left);
        System.out.print(treeNode.val + " ");
        zx(treeNode.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
