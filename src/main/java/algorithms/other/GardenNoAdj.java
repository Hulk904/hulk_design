package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/12/14.
 * 1042. 不邻接植花
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。

 另外，所有花园 最多 有 3 条路径可以进入或离开.

 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。

 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。

 */
public class GardenNoAdj {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] g = new ArrayList[n];//邻接表
        for (int[] p:paths){
            int a = p[0] - 1, b = p[1] - 1;
            //无向边
            if (g[a] == null) g[a] = new ArrayList();
            g[a].add(b);
            if (g[b] == null) g[b] = new ArrayList();
            g[b].add(a);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            boolean st[] = new boolean[5];
            if (g[i] != null){
                for (int j:g[i]){//枚举所有邻点
                    st[res[j]] = true;
                }
            }
            for (int j = 1; j <= 4; j++){//当前点染任意一个没用的颜色
                if (!st[j]){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}
