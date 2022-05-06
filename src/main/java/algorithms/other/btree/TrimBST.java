package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/27.
 * 669. 修剪二叉搜索树
 *
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。
 * 通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 */
public class TrimBST {

    /**
     * 递归实现需要理解。。。
     * 首先得是搜索树才能这样处理
     * 不可能修剪后 左右子树同时存在 ， 因为它是一个搜索树
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        //修剪左分支
        if (root.val > R) return trimBST(root.left, L, R);
        //修剪右分支
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
