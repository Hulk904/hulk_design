package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.*;

/**
 * Created by yangyuan on 2020/7/18.
 * 107. 二叉树的层次遍历 II
 给定一个二叉树，返回其节点值自底向上的层次遍历。
 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderBottom {

    /**
     * 跟102差不多， 最后reverse一下就行。 记住 Collections的reverse 方法。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            while (size-- > 0){
                TreeNode cur = queue.poll();
                item.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(item);
        }
        Collections.reverse(res);
        return res;
    }
}
