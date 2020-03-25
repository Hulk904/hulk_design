package algorithms.other;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/3/3.
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


}
