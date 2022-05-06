package algorithms.other.btree;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/5/9.
 * 814. 二叉树剪枝
 *
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

 返回移除了所有不包含 1 的子树的原二叉树。

 ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

 */
public class PruneTree {

    //自己写的， 还是比较厉害的。
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }

    int dfs(TreeNode root){
        if (root == null) return 0;
        int left =dfs(root.left);
        int right = dfs(root.right);
        if (left == 0){
            root.left = null;
        }
        if (right == 0){
            root.right = null;
        }
        return root.val + left + right;
    }

    //方法二
    //更短小
    public TreeNode pruneTree2(TreeNode root) {
        if(!dfs2(root)) return null;
        return root;
    }
    //是否包含1
    boolean dfs2(TreeNode root){
        if(root == null) return false;
        if (!dfs2(root.left)) root.left = null;
        if (!dfs2(root.right)) root.right = null;
        return root.val > 0 || root.left != null || root.right != null;
    }
}
