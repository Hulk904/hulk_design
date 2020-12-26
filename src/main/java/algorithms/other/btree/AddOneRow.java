package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/12/19.
 */
public class AddOneRow {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode cur = new TreeNode(v);
            cur.left = root;
            return cur;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        for (int i = 0; i < d - 2; i++){
            for (int j = deque.size(); j > 0; j--){
                TreeNode t = deque.removeFirst();
                if (t.left != null) deque.addLast(t.left);
                if (t.right != null) deque.addLast(t.right);
            }
        }
        while (deque.size() > 0){
            TreeNode cur = deque.pollFirst();
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = cur.left;
            right.right = cur.right;
            cur.left = left;
            cur.right = right;
        }
        return root;
    }
}
