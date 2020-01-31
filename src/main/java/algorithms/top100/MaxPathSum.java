package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/26.
 *
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
        Integer[] data = {13, -2, 12,null, null, 14, 15};
        TreeNode treeNode = TreeUtil.buildTree(data);
        System.out.println(new MaxPathSum().maxPathSum(treeNode));

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
