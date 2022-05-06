package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/6/26.
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 直接遍历。 由于是二叉搜索树可以进行相关剪枝
 */
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int val = root.val;
        if (val >= low && val <= high){
            return val + rangeSumBST(root.left,low, high) + rangeSumBST(root.right, low, high);
        } else if (val < low){
            return rangeSumBST(root.right, low, high);
        } else {
            return rangeSumBST(root.left, low, high);
        }
    }
}
