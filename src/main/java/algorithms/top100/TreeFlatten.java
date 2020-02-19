package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/6.
 * 给定一个二叉树，原地将它展开为链表。

 例如，给定二叉树

 1
 / \
 2   5
 / \   \
 3   4   6
 将其展开为：

 1
  \
   2
   \
    3
     \
     4
      \
       5
        \
         6
 */
public class TreeFlatten {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode nodeRight = new TreeNode(2);
        root.left = nodeRight;
        flatten(root);
        System.out.println(JSON.toJSONString(root));
    }

    public static void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode leftRight = root.left;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                leftRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
}
