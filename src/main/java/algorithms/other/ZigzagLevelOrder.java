package algorithms.other;

import algorithms.TreeNode;

import java.util.*;

/**
 * Created by yangyuan on 2020/3/23.
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {


    /**
     * 两个栈实现
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        List<List<Integer>> res = new ArrayList();
        int i = 1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> item = new ArrayList();
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    item.add(node.val);
                    if ((i & 1) == 0){
                        if (node.right != null){
                            stack2.push(node.right);
                        }
                        if (node.left != null){
                            stack2.push(node.left);
                        }
                    } else {
                        if (node.left != null){
                            stack2.push(node.left);
                        }
                        if (node.right != null){
                            stack2.push(node.right);
                        }
                    }
                }
            }else {
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    item.add(node.val);
                    if ((i & 1) == 0){
                        if (node.right != null) {
                            stack1.push(node.right);
                        }
                        if (node.left != null){
                            stack1.push(node.left);
                        }
                    } else {
                        if (node.left != null){
                            stack1.push(node.left);
                        }
                        if (node.right != null) {
                            stack1.push(node.right);
                        }

                    }
                }
            }
            i++;
            res.add(item);
        }
        return res;
    }

    /**
     * 双端队列   前取后放，后取前放
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            if (flag){
                while (size-- > 0){
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null){
                        deque.addLast(node.left);
                    }
                    if (node.right != null){
                        deque.addLast(node.right);
                    }
                }
            } else {
                while (size-- > 0){
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null){
                        deque.addFirst(node.right);
                    }
                    if (node.left != null){
                        deque.addFirst(node.left);
                    }
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;

    }

}
