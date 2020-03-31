package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/26.
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class LongestUnivaluePath {

    int res ;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode node){
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int l = 0, r = 0;
        if (node.left != null && node.val == node.left.val){
            l = left + 1;
        }
        if (node.right != null && node.val == node.right.val){
            r = right + 1;
        }
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }

}
