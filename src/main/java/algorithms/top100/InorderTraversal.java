package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/4.
 * <p>
 * 给定一个二叉树，
 * 迭代和递归实现。。。。
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode nodeRight = new TreeNode(3);
        root.right = nodeRight;
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        //System.out.println(JSON.toJSONString(inorder(root)));
        postOrder(root);//先序遍历

    }

    /**
     * 返回它的中序  遍历。
     * 迭代实现
     *
     * @param root
     * @return
     */
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;//当前遍历节点 有利于理解整个算法
        while (cur != null || stack.size() > 0) {//条件。。。
//            if (stack.peek().left == null){
//                result.add(stack.pop().val);
//            } else {
//                stack.push(stack.peek().left);
//            }
//            TreeNode temp = stack.pop();
//            result.add(temp.val);
//            if (temp.right != null){
//                stack.push(temp.right);
//            }
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;// 理解这一块
        }
        return result;
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        doTravel(root, result);
        return result;
    }

    private static void doTravel(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            doTravel(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            doTravel(root.right, result);
        }

    }


    /**
     * 先序 遍历
     * 两个连表实现
     *
     * @param root
     * @return
     */
    public static List<Integer> preorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;

    }

    /**
     * 后序遍历
     * 结果保存在连表中
     * @param root
     * @return
     */
    public static List<Integer> postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /**
     * 后序遍历直接输出结果
     * @param root
     */
    public static void postOrder(TreeNode root) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
    }
}
