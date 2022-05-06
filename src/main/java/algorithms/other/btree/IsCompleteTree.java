package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/7/6.
 * 958. 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。

 百度百科中对完全二叉树的定义如下：

 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）

 */
public class IsCompleteTree {
    int n = 0 /* 节点数*/, p = 0/* 编号最大值 */;
    public boolean isCompleteTree(TreeNode root) {
        if(!dfs(root, 1)) return false;
        return n == p;
    }

    boolean dfs(TreeNode root, int k){
        if (root == null) return true;
        if ( k > 100) return false;
        n++; p = Math.max(p, k);
        return dfs(root.left, k*2) && dfs(root.right, 2*k + 1);
    }
}
