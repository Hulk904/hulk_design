package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2021/7/18.
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。

 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。

 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。

 返回二叉树的 垂序遍历 序列。

 */
public class VerticalTraversal {

    Map<Integer, List<int[]>> map = new TreeMap();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList();
        for (Map.Entry<Integer, List<int[]>> entry:map.entrySet()){
            List<int[]> v = entry.getValue();
            v = v.stream().sorted((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : a[0] - b[0]).collect(Collectors.toList());
            List<Integer> col = new ArrayList();
            for (int[] p:v) {
                col.add(p[1]);
            }
            res.add(col);
        }
        return res;
    }

    void dfs(TreeNode root, int x, int y){
        if (root == null) return;
        if (map.get(y) == null){
            map.put(y, new ArrayList());
        }
        map.get(y).add(new int[]{x, root.val});
        dfs(root.left,x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }
}
