package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/4/18.
 * 110. 平衡二叉树
 * 面试题55 - II. 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class IsBalanced {

    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalance;
    }

    /**
     * 求树的深度
     * 顺道判断是不是平衡树
    */
    int depth(TreeNode node){
        if (node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (Math.abs(left - right) >= 2) isBalance = false;
        return Math.max(left, right) + 1;
    }
}
