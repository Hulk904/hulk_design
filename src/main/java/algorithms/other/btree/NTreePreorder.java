package algorithms.other.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/12/5.
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class NTreePreorder {

    List<Integer> res = new ArrayList();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }

    void dfs(Node root){
        if (root == null) return;
        res.add(root.val);
        for (Node n:root.children){
            dfs(n);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
