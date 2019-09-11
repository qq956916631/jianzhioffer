package chapter4;

import org.junit.Test;

import java.util.Stack;

/*
总结：
    基于后序遍历：
        反序列化借助一个栈，然后扫描序列化字符串：
            当碰到'#'的时候压入一个null结点
            当碰'!'的时候从栈中弹出2个结点，作为当前节点的右子树和左子树，然后再将当前节点压栈
    基于前序遍历：
        反序列化借助递归
*/
public class 面试题37序列化二叉树 {
    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(Serialize(root.left));
        sb.append(root.val + "!");
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        return DeserializeByQx(str);
    }

    int point = 0;  // java形参没有引用类型，只能设置成全局变量，或者将形参设成数组
    TreeNode DeserializeByQx(String str) { //反序列化前序字符串
        if (str.charAt(point) == '#') {
            point++;
            return null;
        }
        int num = 0;
        char c;
        while ((c = str.charAt(point++)) != '!')
            num = num * 10 + c - '0';
        TreeNode node = new TreeNode(num);
        node.left = DeserializeByQx(str);
        node.right = DeserializeByQx(str);
        return node;
    }

    TreeNode DeserializeByZx(String str) { //反序列化中序字符串
        return null;
    }

    TreeNode DeserializeByHx(String str) { //反序列化后序字符串
        Stack<TreeNode> stack = new Stack<>();
        int point = 0;
        int num = 0;
        while (point < str.length()) {
            char c = str.charAt(point++);
            if (c == '#') {
                stack.add(null);
            } else if (c >= '0' && c <= '9')
                num = num * 10 + c - '0';
            else { // c == '!'
                TreeNode node = new TreeNode(num);
                TreeNode rightChild = stack.pop();
                TreeNode leftChild = stack.pop();
                node.left = leftChild;
                node.right = rightChild;
                stack.add(node);
                num = 0;
            }
        }
        return stack.pop();
    }


    @Test
    public void test() {
        /*
         *           5
         *       3       6
         *   2       4
         * 1
         * */
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
        String str = Serialize(t1);
       // TreeNode root = Deserialize(str);
        System.out.println(str);
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
