package algorithms.top100;

import algorithms.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/20.
 */
public class MergeTrees {

    public static void main(String[] args) {

    }

    public TreeNode mergeTreesTimes2(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{t1, t2});
        while (!queue.isEmpty()){
            TreeNode[] cur = queue.poll();
            if (cur[1]== null){
                continue;
            }
            if (cur[0] == null){
                cur[0] = cur[1];
                continue;
            }
            cur[0].val += cur[1].val;
            if (cur[0].left != null){
                queue.add(new TreeNode[]{cur[0].left, cur[1].left});
            } else {
                cur[0].left = cur[1].left;
            }
            if (cur[0].right != null){
                queue.add(new TreeNode[]{cur[0].right, cur[1].right});
            } else {
                cur[0].right = cur[1].right;
            }
        }
        return t1;
    }

    /**
     * 迭代
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTreesIter(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()){
            TreeNode[] cur = stack.pop();
            if (cur[0] == null){
                cur[0] = cur[1];
            }
            if (cur[1] == null){
                continue;
            }
            cur[0].val += cur[1].val;
            if (cur[0].left != null){
                stack.push(new TreeNode[]{cur[0].left, cur[1].left});
            } else {
                cur[0].left = cur[1].left;
            }
            if (cur[0].right != null){
                stack.push(new TreeNode[]{cur[0].right, cur[1].right});
            } else {
                cur[0].right = cur[1].right;
            }
        }
        return t1;
    }

    /**
     * 递归
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t2 == null) return t1;
        if (t1 == null) return t2;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees2(t1.left, t2.left);
        node.right = mergeTrees2(t1.right, t2.right);
        return node;
    }
}
