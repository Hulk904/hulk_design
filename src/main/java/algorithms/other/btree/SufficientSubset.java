package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/12/26.
 * 1080. 根到叶路径上的不足节点
 *
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）

 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。

 请你删除所有不足节点，并返回生成的二叉树的根。

 */
public class SufficientSubset {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean delete = dfs(root, 0, limit);
        if (delete) return null;
        return root;
    }
    /**
     * @return 返回 node 结点是否被删除（注意：这个返回值的意义，直接影响整个逻辑。）
     */
    private Boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null) {
            return s + node.val < limit;
        }

        // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
        boolean lTreeDeleted = true;
        boolean rTreeDeleted = true;

        // 如果有左子树，就先递归处理左子树
        if (node.left != null) {
            lTreeDeleted = dfs(node.left, s + node.val, limit);
        }
        // 如果有右子树，就先递归处理右子树
        if (node.right != null) {
            rTreeDeleted = dfs(node.right, s + node.val, limit);
        }

        // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
        if (lTreeDeleted) {
            node.left = null;
        }
        if (rTreeDeleted) {
            node.right = null;
        }
        // 只有左右子树都被删除了，自己才没有必要保留
        return lTreeDeleted && rTreeDeleted;
    }
}
