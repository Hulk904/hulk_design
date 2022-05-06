package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/7/11.
 * 971. 翻转二叉树以匹配先序遍历
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。

 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。

 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。 

 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 */
public class FlipMatchVoyage {
    int k = 0;
    int[] voyage;
    List<Integer> res = new ArrayList();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        if (dfs(root)) return res;
        return new ArrayList(){{add(-1);}};
    }

    boolean dfs(TreeNode root){
        if (root == null) return true;
        if (root.val != voyage[k]) return false;
        k++;
        if (root.left != null && root.left.val != voyage[k]){
            res.add(root.val);
            return dfs(root.right) && dfs(root.left);
        } else {
            return dfs(root.left) && dfs(root.right);
        }
    }
}
