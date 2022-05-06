package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/12/27.
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class FindTarget {

    /**
     * 这里使用 set ，好像没使用到bst的特性
     */
    Set<Integer> set = new HashSet();
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    boolean dfs(TreeNode root , int k){
        if (root == null) return false;
        if (dfs(root.left, k)) return true;
        int x = root.val;
        if (set.contains(k - x)) return true;
        set.add(x);
        return dfs(root.right, k);
    }
}
