package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/11/29.
 *
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 */
public class IsSubtree {

    /**
     * 递归实现
     *
     * 看到题目描述，首先判断一个树是否是另一棵树的子树，很明显想到可以用递归，但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
     所以自然而然想到用一个判断两棵树是否相同的递归函数。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    int p = 131 ,q = 159, MOD = (int)1e7 + 7;
    int T = -1;
    boolean ans = false;

    /**
     * 树哈希  没看懂
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        T = dfs (t);
        if (T == dfs(s)) ans = true;
        return ans;
    }

    int dfs(TreeNode root){
        if (root == null) return 1234;
        int left = dfs(root.left), right = dfs(root.right);
        int x = (root.val %MOD + MOD)%MOD;
        if (left == T || right == T) ans = true;
        return (x + left*p % MOD + right*q)%MOD;
    }

}
