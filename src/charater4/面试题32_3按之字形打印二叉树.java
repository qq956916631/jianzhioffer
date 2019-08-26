package charater4;

import org.junit.Test;

import java.util.*;

public class 面试题32_3按之字形打印二叉树 {
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNodeWithRow> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        queue.add(new TreeNodeWithRow(root, 0));
        TreeNodeWithRow preNode = queue.peek();
        while (!queue.isEmpty()) {
            TreeNodeWithRow node = queue.remove();
            if (node.node.left != null)
                queue.add(new TreeNodeWithRow(node.node.left, node.row + 1));
            if (node.node.right != null)
                queue.add(new TreeNodeWithRow(node.node.right, node.row + 1));

            if (node.row > preNode.row) {
                arrayList.add(row);
                row = new ArrayList<>();
            }
            row.add(node.node.val);
            preNode = node;
        }
        arrayList.add(row);
        return arrayList;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t7.right = t8;
        t8.left = t9;
        ArrayList<ArrayList<Integer>> arrayList = PrintFromTopToBottom(t1);
        for (ArrayList<Integer> row : arrayList)
            System.out.println(row);
    }

    private class TreeNodeWithRow {
        TreeNode node;
        int row;

        public TreeNodeWithRow(TreeNode node, int row) {
            this.node = node;
            this.row = row;
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
