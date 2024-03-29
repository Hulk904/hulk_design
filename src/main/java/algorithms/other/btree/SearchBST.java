package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/3/13.
 *
 * 700. 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val < val) return searchBST(root.right, val);
        if (root.val > val) return searchBST(root.left, val);
        return root;
    }
}
