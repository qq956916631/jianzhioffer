package charater4;

import org.junit.Test;
/*
总结：
    ConvertNode(TreeNode root): 可以得到以根为root的二叉树转换后的链表，但仅仅返回root，而不是该链表的头节点

*/
public class 面试题36二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        TreeNode treeNode = ConvertNode(root);
        while (treeNode.left != null)
            treeNode = treeNode.left;
        return treeNode;
    }

    public TreeNode ConvertNode(TreeNode root) {
        if (root.left != null) {
            TreeNode leftNode = ConvertNode(root.left);
            while (leftNode.right != null)
                leftNode = leftNode.right;
            leftNode.right = root;
            root.left = leftNode;
        }
        if (root.right != null) {
            TreeNode rightNode = ConvertNode(root.right);
            while (rightNode.left != null)
                rightNode = rightNode.left;
            rightNode.left = root;
            root.right = rightNode;
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        TreeNode root = Convert(t1);
        printTree(root);
    }

    private void printTree(TreeNode root) {
        while (root != null) {
            System.out.println(root);
            root = root.right;
        }
    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "(" + (left == null ? "null" : left.val) + ")" + " " + val + " " + "(" + (right == null ? "null" : right.val) + ")";
        }
    }
}
