package algorithms.other;

import algorithms.TreeNode;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/2/29.
 * 173. 二叉搜索树迭代器
 *
 * 把二叉树迭代实现分开。。。
 * next 平均时间复杂度可以 为 o(1)
 * 空间复杂度 o(h)
 */
public class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    public BSTIterator(TreeNode root) {
        if (root == null){
            return;
        }
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if (stack.isEmpty()){
            throw new IndexOutOfBoundsException("");
        }
        TreeNode cur = stack.pop();
        int result = cur.val;
        cur = cur.right;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return result;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
