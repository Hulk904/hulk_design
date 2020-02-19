package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/21.
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

 */
public class ConvertBST {

    private Integer sum = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{5,2,13});
        System.out.println(JSON.toJSONString(convertBSTWithStack(root)));

    }

    /**
     * 使用栈实现
     * @param root
     * @return
     */
    public static TreeNode convertBSTWithStack(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }


    /**
     * 递归    一个反序中序遍历的方法是通过递归实现
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null){
            return root;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}
