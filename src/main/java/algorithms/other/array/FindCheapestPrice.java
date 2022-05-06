package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/4/17.
 *
 * 787. K 站中转内最便宜的航班
 *
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。

 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。

 */
public class FindCheapestPrice {
    int MAX = (int)1e8;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        dist[src] = 0;
        K++;
        while (K-- > 0){//
            int[] cur = Arrays.copyOf(dist, dist.length);
            for (int[] e:flights){
                int a = e[0], b = e[1], c = e[2];
                cur[b] = Math.min(cur[b], dist[a] + c);
            }
            dist = cur;
        }
        if (dist[dst] == MAX) return -1;
        return dist[dst];
    }
}
