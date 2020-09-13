package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/7/25.
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

 例如，从根到叶子节点路径 1->2->3 代表数字 123。

 计算从根到叶子节点生成的所有数字之和。

 */
public class SumNumbers {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int num){
        if (root == null) return;
        num = num*10 + root.val;
        if (root.left == null && root.right == null){
            res += num;
        }
        if (root.left != null) dfs(root.left, num);
        if (root.right != null) dfs(root.right, num);
    }
}
