package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/6/5.
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class IncreasingBST {
    TreeNode tail ;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        tail = dummy;
        dfs(root);
        return dummy.right;
    }
    void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        tail = tail.right = root;
        root.left = null;
        dfs(root.right);
    }
}
