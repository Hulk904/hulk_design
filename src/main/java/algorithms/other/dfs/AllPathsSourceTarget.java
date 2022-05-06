package algorithms.other.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2021/4/29.
 * 797. 所有可能的路径
 *
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。

 */
public class AllPathsSourceTarget {
    int[][] g ;
    List<List<Integer>> ans = new ArrayList();
    Stack<Integer> path;//每次路径
    int n;//节点个数

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        g = graph;
        path = new Stack();
        dfs(0);
        return ans;
    }

    void dfs(int u){
        path.push(u);
        if (u == n - 1) ans.add(new ArrayList(path));//不要break ，可能到了终点又回来
        for (int v:g[u]) dfs(v);
        path.pop();
    }

    //这样也行
    void dfs2(int u){
        path.push(u);
        if (u == n - 1) {
            ans.add(new ArrayList(path));
            path.pop();
            return ;
        }
        for (int v:g[u]) dfs2(v);
        path.pop();
    }
}
