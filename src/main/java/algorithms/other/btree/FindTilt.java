package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/11/28.
 * 563. 二叉树的坡度
 *
 * 给定一个二叉树，计算 整个树 的坡度 。

 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。

 整个树 的坡度就是其所有节点的坡度之和。

 */
public class FindTilt {

    int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    /**
     * 返回子树和
     * @param root
     * @return
     */
    int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left - right);
        return left + right + root.val;
    }
}
