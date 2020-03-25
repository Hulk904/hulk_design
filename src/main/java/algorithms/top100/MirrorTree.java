package algorithms.top100;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/1/4.
 */
public class MirrorTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode nodeRight = new TreeNode(2);
        root.right = nodeRight;
        TreeNode node1 = new TreeNode(4);
        root.left = node1;
        TreeNode nodeLeft = new TreeNode(3);
        nodeRight.left = nodeLeft;
        //System.out.println(isSymmetric(root));
        System.out.println(isSymmetricIteration(root));

    }

    public static boolean isSymmetricIteration(TreeNode root){
        if (root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null){
                continue;
            }
            if (node1 == null || node2 == null){
                return false;
            }
            if (node1.val != node2.val){
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        }
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //注意这里的比较对象 不是 （left.left,left.right）和 (right.left,right.right);
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
