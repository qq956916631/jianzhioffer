package chapter4;

import org.junit.Test;

import java.util.ArrayList;
/*
总结：
    FindPath(TreeNode root, int target)解决的问题是找到以root为根的树，和为target的路径。
    要解决这个问题，需要以下步骤
        1.以左孩子为根的树，和为target-root.val的路径（子问题）
        2.以右孩子为根的树，和为target-root.val的路径（子问题）
        3.遍历1、2两步得到的路径结果，然后将root.val插到路径结果最前面
    可以看出这个问题的结果可以由其子问题的结果合并得到，所以可以使用递归来解决。
    最后需要注意按照路径长度从大到小排序一下路径，参照归并排序合并有序元素时的思想即可。
*/
public class 面试题34二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null && root.val == target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            res.add(path);
            return res;
        }

        ArrayList<ArrayList<Integer>> leftRes = FindPath(root.left, target - root.val);
        ArrayList<ArrayList<Integer>> rightRes = FindPath(root.right, target - root.val);
        addValToPath(leftRes, root.val);
        addValToPath(rightRes, root.val);

        // 保证数据长度长的排前面。用类似归并排序合并有序的思想，因为leftRes、rightRes已经有序
        int leftPoint = 0, rightPoint = 0;
        while (leftPoint != leftRes.size() && rightPoint != rightRes.size()) {
            if (leftRes.get(leftPoint).size() > rightRes.get(rightPoint).size())
                res.add(leftRes.get(leftPoint++));
            else
                res.add(rightRes.get(rightPoint++));
        }
        while (leftPoint < leftRes.size())
            res.add(leftRes.get(leftPoint++));
        while (rightPoint < rightRes.size())
            res.add(rightRes.get(rightPoint++));
        return res;
    }

    private void addValToPath(ArrayList<ArrayList<Integer>> res, int val) {
        for (ArrayList<Integer> path : res)
            path.add(0, val);
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(3);
        t1.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        ArrayList<ArrayList<Integer>> res = FindPath(t1, 22);
        for (ArrayList<Integer> path : res)
            System.out.println(path);
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
