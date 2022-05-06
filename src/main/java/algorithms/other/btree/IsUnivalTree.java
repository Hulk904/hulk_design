package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/4/19.
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 */
public class IsUnivalTree {
    boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        travel(root);
        return flag;
    }

    void travel (TreeNode root){
        if (root == null) return;
        if (root.left != null && root.val != root.left.val) {
            flag = false;
            return;
        }
        if (root.right != null && root.val != root.right.val) {
            flag = false;
            return;
        }
        travel(root.left);
        travel(root.right);
    }


    /**
     *  另一种递归方式
     * @param root
     * @return
     */
    public boolean isUnivalTree2(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree2(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree2(root.right)));
        return left_correct && right_correct;
    }

    public boolean isUnivalTree3(TreeNode root) {
        return dfs(root, root.val);
    }

    boolean dfs(TreeNode root, int val){
        if (root == null) return true;
        if (root.val != val) return false;
        return dfs(root.left, val) && dfs(root.right, val);
    }

}
