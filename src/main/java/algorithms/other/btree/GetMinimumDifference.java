package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/11/21.
 *
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class GetMinimumDifference {

    int res = Integer.MAX_VALUE;

    Integer pre = null;

    /**
     *  二叉搜索树的特点就是 中序遍历有序，所以最小值一定是在相邻节点之间
     *  问题是怎么传递遍历过程中的前一个节点。
     *  递归写法真的不是很好懂啊。。
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        if (pre != null){
            res = Math.min(res, node.val - pre);
        }
        pre = node.val;
        dfs(node.right);
    }
}
