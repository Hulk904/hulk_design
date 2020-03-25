package algorithms.top100;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/1/5.
 *
 * 104. 二叉树的最大深度
 * 二叉树深度
 */
public class BTreeDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode nodeRight = new TreeNode(2);
        root.right = nodeRight;
        TreeNode node1 = new TreeNode(4);
        root.left = node1;
        TreeNode nodeLeft = new TreeNode(3);
        nodeRight.left = nodeLeft;
        System.out.println(maxDepthIterator(root));
    }


    public static int maxDepthIterator(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (queue.size() > 0){
            int itemNum = queue.size();
            for (int i = 0; i < itemNum; i++){
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level ++;
        }
        return level;
    }


    /**
     * 递归实现
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
