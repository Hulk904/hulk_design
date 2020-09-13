package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangyuan on 2020/8/8.
 * 前序遍历
 */
public class PreOrderTree {

    /**
     * 先序 遍历
     * 两个连表实现
     *
     * @param root
     * @return
     */
    public static List<Integer> preorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;

    }

}
