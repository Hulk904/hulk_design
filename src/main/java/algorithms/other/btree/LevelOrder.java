package algorithms.other.btree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/10/24.
 * 429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> item = new ArrayList<>();
            while (len-- > 0){
                Node node = queue.poll();
                item.add(node.val);
                for (Node node1:node.children) {
                    queue.add(node1);
                }
            }
            res.add(item);
        }
        return res;
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