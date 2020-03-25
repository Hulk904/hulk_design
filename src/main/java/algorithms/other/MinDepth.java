package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/2/13.
 *
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。
 */
public class MinDepth {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树为空或者右子树为空，不代表就可以退出了，而是继续计算另一分支，仔细品品。。。
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}
