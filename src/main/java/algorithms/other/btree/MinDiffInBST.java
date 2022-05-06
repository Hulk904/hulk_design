package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/4/15.
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class MinDiffInBST {


    int ans = Integer.MAX_VALUE;
    Integer pre = null;
    //中序遍历  计算相邻元素最小差值就行了
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root){
        if (root == null) return;
        dfs(root.left);
        if (pre == null){
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);

        }
        pre = root.val;
        dfs(root.right);
    }
}
