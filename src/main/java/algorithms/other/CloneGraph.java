package algorithms.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/7/26.
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。

 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class CloneGraph {

    Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        dfs(node);
        //遍历所有的边然后复制
        for (Map.Entry<Node,Node> entry:map.entrySet()){
            for (Node n:entry.getKey().neighbors){
                if (entry.getValue().neighbors == null){
                    entry.getValue().neighbors = new ArrayList();
                }
                entry.getValue().neighbors.add(map.get(n));

            }
        }
        return map.get(node);
    }

    /**
     * dfs 记录所有的节点
     * @param node
     */
    void dfs(Node node){
        map.put(node, new Node(node.val));
        for (Node n:node.neighbors){
            if (map.get(n) == null){
                dfs(n);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

