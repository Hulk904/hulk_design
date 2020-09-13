package algorithms.tree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/7/12.
 * 99. 恢复二叉搜索树
 *
 * 二叉搜索树中的两个节点被错误地交换。

 请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverTree {

    private TreeNode first;

    private TreeNode second;

    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);


    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        //不能包含等于 不然 测试用例 [5,3,9,-2147483648,2] 会报错
        if (first == null && pre.val > root.val) first = pre;
        if (first != null && pre.val > root.val) second = root;
        pre = root;
        inOrder(root.right);
    }

}
