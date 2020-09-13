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

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root.left, r = root.right;
        int x = 1, y = 1;
        while (l != null) {
            l = l.left;
            x++;
        }
        while(r != null){
            r = r.right;
            y++;
        }
        if (x == y) return (int)Math.pow(2, x) - 1;
        return countNodes2(root.left) + 1 + countNodes2(root.right);
    }
}
