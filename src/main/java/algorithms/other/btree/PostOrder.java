package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后续遍历二叉树
 * Created by yangyuan on 2020/8/8.
 */
public class PostOrder {
    /**
     * 后序遍历直接输出结果
     * @param root
     */
    public static void postOrder(TreeNode root) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }

    /**
     * 后序遍历
     * 结果保存在连表中
     * @param root
     * @return
     */
    public static List<Integer> postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}
