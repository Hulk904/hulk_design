package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/25.
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。


 */
public class SortedArrayToBST {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int left, int right){
        if (left > right) {
            return null;
        }
        int mid = (left + right)  >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid - 1);
        node.right = helper(mid + 1, right);
        return node;
    }
}
