package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/26.
 * 222. 完全二叉树的节点个数
 *
 *
 * 理由完全二叉树的特点
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        int left = leftLevel(root.left);
        int right = leftLevel(root.right);
        if (left == right){
            return count += Math.pow(2, left) - 1 + countNodes(root.left);
        } else {
            return count += Math.pow(2, right) - 1 + countNodes(root.right);
        }
    }

    int leftLevel(TreeNode node){
        if (node == null) return 0;
        return 1 + leftLevel(node.left);
    }
}
