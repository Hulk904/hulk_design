package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2020/11/15.
 *
 * 515. 在每个树行中找最大值
 *
 * 您需要在二叉树的每一行中找到最大的值。
 */
public class LargestValues {

    Map<Integer, Integer> map = new HashMap();

    int max = 0;

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 1);
        List<Integer> res = new ArrayList();
        for (int i = 1; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }

    void dfs(TreeNode  root, int d){
        if (root == null) return;
        max = Math.max(max, d);
        if (map.get(d) == null) map.put(d, root.val);//当前层没有，设置当前val
        else map.put(d, Math.max(map.get(d), root.val));//设置最大值
        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

    //bfs  比较直接些。。
}
