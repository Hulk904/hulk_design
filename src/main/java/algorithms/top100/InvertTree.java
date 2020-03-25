package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/1/12.
 *
 * 翻转一棵二叉树。

 示例：

 输入：

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

       4
     /   \
    7     2
   / \   / \
 9   6 3   1

 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(1);
        root.left = nodeRight;
        TreeNode node1 = new TreeNode(3);
        root.right = node1;
        TreeNode node2 = new TreeNode(4);
        node1.left = node2;
        System.out.println(JSON.toJSONString(invertTreeIter(root)));
    }

    public static TreeNode invertTreeIter(TreeNode root){
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            TreeNode temp = cur.right;
            cur.right=cur.left;
            cur.left=temp;
        }
        return root;
    }


    /**
     * 递归实现
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}
