package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/7/19.
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSum2 {

    List<List<Integer>> res = new ArrayList<>();

    Stack<Integer> path = new Stack();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum){
        if (root == null) return;
        sum -= root.val;
        path.push(root.val);
        if (root.left == null && root.right == null){
            if (sum == 0){
                res.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
        path.pop();
    }
}
