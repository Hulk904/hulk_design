package algorithms.other.dfs;

import algorithms.TreeNode;

/**
 * Created by yangyuan on 2021/11/29.
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。

 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 */
public class SumRootToLeaf {

    //使用全局变量，比较好理解
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    void dfs(TreeNode root, int x){
        if (root == null) return ;
        if (root.left == null && root.right == null){
            sum += root.val + x*2;
            return;
        }
        dfs(root.left, root.val + x*2);
        dfs(root.right, root.val + x*2);
    }




    public int sumRootToLeaf2(TreeNode root) {
        return dfs2(root, 0);
    }
    int dfs2(TreeNode root, int x){
        x = x*2 + root.val;
        if (root.left == null && root.right == null) return x;
        int sum = 0;
        if (root.left != null) sum += dfs2(root.left, x);
        if (root.right != null) sum += dfs2(root.right, x);
        return sum;
    }



    public int sumRootToLeafErr(TreeNode root) {
        return dfsErr(root, 0);
    }
    int dfsErr(TreeNode root, int x){

        if (root.left == null && root.right == null) return root.val;
        int sum = x*2 + root.val;
        if (root.left != null) sum += dfsErr(root.left, sum);
        if (root.right != null) sum += dfsErr(root.right, sum);
        return sum;
    }
}
