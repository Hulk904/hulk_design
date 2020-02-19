package algorithms.top100;

import algorithms.TreeNode;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/5.
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。

 */
public class BstCheck {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(1);
        root.left = nodeRight;
        TreeNode node1 = new TreeNode(3);
        root.right = node1;
        //System.out.println(isSymmetric(root));
        System.out.println(isValidBSTTimes2(root));
    }

    public static boolean isValidBSTTimes2(TreeNode root){
        if(root == null){
           return true;
        }
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= pre) return false;
            pre = cur.val;
            cur = cur.right;
        }
        return true;
    }

    /**
     * 主体中序遍历
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root){
        if (root == null ) return true;
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        long b = Long.MIN_VALUE; //不要事先把cur放在stack中 ，不然处理不是很方便
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val <= b) return false;
            b = cur.val;
            cur = cur.right;
        }
        return true;
    }

    /*
     Stack<TreeNode> stack = new Stack();
    double inorder = - Double.MAX_VALUE;
     TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (cur.val <= inorder) return false;
      inorder = cur.val;
      cur = cur.right;
    }
    return true;
     */


    /**
     * 递归实现
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root){
        return checkBST(root, null, null);
    }


    private static boolean checkBST(TreeNode node, Integer lower, Integer high){
        if (node == null){
            return true;
        }
        if (lower != null && node.val <= lower) return false;
        if (high != null && node.val >= high) return false;
        return checkBST(node.left, lower, node.val)&&checkBST(node.right, node.val, high);
    }



    /**
     * 错误的递归  只考虑了当前节点和子节点关系
     *
     *     10
     *      \
     *      15
     *      / \
     *     6  20
     *     对这样的结构判断将是错误的
     * @param root
     * @return
     */
    public static boolean isValidBSTFalse(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left != null && root.left.val >= root.val){
            return false;
        }
        if (root.right != null && root.right.val <= root.val){
            return false;
        }
        return  isValidBSTFalse(root.left) && isValidBSTFalse(root.right);
    }
}
