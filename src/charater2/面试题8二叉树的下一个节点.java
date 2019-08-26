package charater2;

import org.junit.Test;

/*
总结：
    分三种情况：
    1. 该节点有右子树，则选择右子树最小的值即可
    2. 若没有右子树，且该节点是父节点的左子节点，那么父节点就为下一个节点
    3. 若该节点是父节点的右子节点，那么就向上遍历找到以它们为左子节点的父子节点
*/
public class 面试题8二叉树的下一个节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null) // 情况1
            return getMinTreeLinkNode(pNode.right);
        // 情况2、3
        TreeLinkNode current = pNode;
        while (current.next != null && current.next.left != current)
            current = current.next;
        return current.next;
    }

    private TreeLinkNode getMinTreeLinkNode(TreeLinkNode root) {
        if (root.left == null)
            return root;
        return getMinTreeLinkNode(root.left);
    }

    @Test
    public void test() {
        TreeLinkNode a = new TreeLinkNode('a');
        TreeLinkNode treeLinkNode = GetNext(a);
        System.out.println(treeLinkNode.val);

    }

    class TreeLinkNode {
        char val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父节点

        TreeLinkNode(char val) {
            this.val = val;
        }
    }
}
