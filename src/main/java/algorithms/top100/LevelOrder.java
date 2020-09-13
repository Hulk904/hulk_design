package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;
import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/5.
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode nodeRight = new TreeNode(1);
        root.left = nodeRight;
        TreeNode node1 = new TreeNode(3);
        root.right = node1;
        TreeNode node2 = new TreeNode(15);
        node1.left = node2;
        TreeNode node3 = new TreeNode(7);
        node1.right = node3;
        System.out.println(JSON.toJSONString(levelOrderIterator2(root)));

    }

    public static  List<List<Integer>> levelOrderIterator2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                item.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(item);
        }
        return result;
    }

    /**
     * 迭代实现 ，性能更高些  没有加入特殊元素
     * @param root
     * @return
     */
    public static  List<List<Integer>> levelOrderIterator(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (queue.size() > 0){
            result.add(level, new ArrayList<>());
            int itemNum = queue.size();
            /*
             * 这里需要注意
             * itemNum是当前层元素的个数  所以才有了下面的逻辑 这点很重要哦
             */
            for (int i = 0; i < itemNum; i++){
                TreeNode temp = queue.poll();
                result.get(level).add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level ++;
        }
        return result;
    }


    /**
     * 递归实现
     * @param root
     * @return
     */
    public static  List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        doLevel(root, 0, result);
        return result;
    }

    /**
     * 加上层级 信息
     * @param root
     * @param level
     * @param result
     */
    public static void doLevel(TreeNode root, int level , List<List<Integer>> result){
        if (level >= result.size()){
            result.add(level, new ArrayList());
        }
        result.get(level).add(root.val);
        if (root.left != null) doLevel(root.left, level + 1, result);
        if (root.right != null) doLevel(root.right, level + 1, result);
    }


    /**
     * 自己实现 通过加上特殊 标识 达到按层遍历  逻辑不是很直接
     * @param root
     * @return
     */
    public static  List<List<Integer>> levelOrder2(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = null;
        while (queue.size() > 0 ){
            if (item == null){
                item = new ArrayList<>();
            }
            TreeNode cur = queue.poll();
            if (cur == null){
                result.add(new ArrayList<>(item));
                if (queue.size() == 0){
                    break;
                }
                queue.add(null);
                item = null;
                continue;
            }
            item.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return result;

    }

}
