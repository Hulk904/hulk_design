package algorithms.other;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/3.
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。

 说明: 叶子节点是指没有子节点的节点。
 *
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths b = new BinaryTreePaths();
        TreeNode treeNode = TreeUtil.buildTree(new Integer[]{1,2,4});
        b.binaryTreePaths(treeNode);
    }

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        dfs(root, "");
        return result;
    }

    void dfs(TreeNode root, String path){
        if (root.left == null && root.right == null){
            result.add(path + root.val);
            return;
        }
        path += (root.val + "->");
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
    }

    List<String> res = new ArrayList();

    public List<String> binaryTreePath2(TreeNode root) {
        if (root == null) return new ArrayList();
        dfs(root, new Stack());
        return res;
    }

    private void dfs(TreeNode root, Stack<String> stack){
        if (root.left == null && root.right == null){
            stack.push(root.val + "");
            res.add(String.join("->", stack));
            stack.pop();
            return;
        }
        stack.push(root.val + "");
        if (root.left != null){
            dfs(root.left, stack);
        }
        if (root.right != null){
            dfs(root.right, stack);
        }
        stack.pop();
    }




}
