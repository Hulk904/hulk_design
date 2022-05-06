package algorithms.other.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2021/5/17.
 * 851. 喧闹和富有
 *
 * 在一组 N 个人（编号为 0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。

 为了方便起见，我们将编号为 x 的人简称为 "person x "。

 如果能够肯定 person x 比 person y 更有钱的话，我们会说 richer[i] = [x, y] 。注意 richer 可能只是有效观察的一个子集。

 另外，如果 person x 的安静程度为 q ，我们会说 quiet[x] = q 。

 现在，返回答案 answer ，其中 answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。

 */
public class LoudAndRich {
    int[] w;//权值
    List<Integer>[] g;//邻接表
    int[] ans;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        w = quiet;
        g = new ArrayList[n];
        ans = new int[n];
        Arrays.fill(ans, -1);
        for (int[] i:richer){
            int a = i[0], b= i[1];
            if (g[b] == null){
                g[b] = new ArrayList();
            }
            g[b].add(a);
        }
        for (int i = 0; i < n; i++)dfs(i);
        return ans;
    }
    void dfs(int u){
        if (ans[u] != -1) return;
        ans[u] = u;
        if (g[u] != null){
            for (int v:g[u]){
                dfs(v);
                if (w[ans[u]] > w[ans[v]]){
                    ans[u] = ans[v];
                }
            }
        }

    }
}
