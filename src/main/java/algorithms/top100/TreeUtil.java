package algorithms.top100;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/1/18.
 */
public class TreeUtil {

    /**
     * 数组构建tree
     * @param data
     * @return
     */
    public static TreeNode buildTree(Integer[] data){
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (i < data.length) {
                if (data[i] != null) {
                    TreeNode left = new TreeNode(data[i]);
                    cur.left = left;
                    queue.add(left);
                    i++;
                } else {
                    queue.add(null);
                    i++;
                }
            }
            if (i < data.length ) {
                if (data[i] != null) {
                    TreeNode right = new TreeNode(data[i]);
                    cur.right = right;
                    queue.add(right);
                    i++;
                } else {
                    queue.add(null);
                    i++;
                }

            }
        }
        return root;
    }
}
