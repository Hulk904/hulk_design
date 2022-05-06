package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/12/4.
 * 1026. 节点与其祖先之间的最大差值
 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，
 且 A 是 B 的祖先。

 （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）

 */
public class MaxAncestorDiff {

    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    void dfs(TreeNode root, Integer min, Integer max){
        if (root == null) return;
        res = Math.max(res, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
