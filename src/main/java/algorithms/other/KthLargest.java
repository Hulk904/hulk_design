package algorithms.other;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/22.
 * 面试题54. 二叉搜索树的第k大节点
 */
public class KthLargest {
    int cur = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        kth(root, k);
        return res;
    }


    /**
     * 知道二叉搜索树中序遍历会得到有序的递增序列
     * 其实先遍历右子树然后遍历左子树会得到递减的序列。。。 特性。。
     * @param root
     * @param k
     */
    private void kth(TreeNode root, int k){
        if (root == null) return;
        kthLargest(root.right, k);
        cur++;
        if (cur == k){
            res = root.val;
            return;
        }
        kthLargest(root.left, k);
    }
}
