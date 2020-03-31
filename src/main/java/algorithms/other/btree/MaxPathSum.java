package algorithms.other.btree;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;

/**
 * Created by yangyuan on 2020/1/26.
 *124. 二叉树中的最大路径和 跟 687 差不多，主要是多了次判断
 * 给定一个非空二叉树，返回其最大路径和。

 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

 示例 1:

 输入: [1,2,3]

 1
 / \
 2   3

 输出: 6

 */
public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Integer[] data = {14,null,11,null,null,15,15};
        TreeNode treeNode = TreeUtil.buildTree(data);
        System.out.println(new MaxPathSum().maxPathSumTimes2(treeNode));

    }

    public  int maxPathSumTimes2(TreeNode root) {
        System.out.println(maxSum2(root));
        return maxSum;
    }

    public  int maxSum2(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int leftSum = maxSum2(treeNode.left);
        int rightSum = maxSum2(treeNode.right);
        maxSum = Math.max(maxSum, leftSum + rightSum + treeNode.val);
        return Math.max(0, Math.max(leftSum + treeNode.val, rightSum + treeNode.val));//注意 不要直接返回 maxSum2(treeNode.left) 了 ，负数就没必要算上了
    }

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    /**
     * 返回的时候只返回左子树或右子树加上当前节点  但是计算最大值时会包括左右和当前节点
     * @param root
     * @return
     */
    public int maxSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(maxSum(root.left), 0);//左子树最大值
        int right = Math.max(maxSum(root.right), 0);//右子树最大值
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left,right) + root.val;//返回结果不带分叉的
    }

}
