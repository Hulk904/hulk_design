package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/12/27.
 *
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

 二叉树的根是数组中的最大元素。
 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 通过给定的数组构建最大二叉树，并且输出这个树的根节点。

 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for (int n : nums) {
            TreeNode node = new TreeNode(n);
            TreeNode pre = null;




            node.left = pre;
            stack.push(node);
        }
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            stack.peek().right = pre;
            pre = stack.pop();
        }
        return pre;
    }


}
