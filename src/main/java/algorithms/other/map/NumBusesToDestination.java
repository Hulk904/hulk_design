package algorithms.other.map;

import java.util.*;

/**
 * Created by yangyuan on 2021/5/9.
 * 815. 公交路线
 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。

 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。

 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。

 */
public class NumBusesToDestination {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap();// 每个站点会挂载哪些环线
        int[] dist = new int[n];
        Arrays.fill(dist, 1000000);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){//遍历所有路线
            for (int x:routes[i]){
                if (x == source){
                    dist[i] = 1;
                    queue.add(i);
                }
                if (map.get(x) == null){
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(i);
            }
        }
        //bfs
        while (!queue.isEmpty()){
            int t = queue.poll();
            for (int x:routes[t]){
                if (x == target) return dist[t];
                if (map.get(x) != null){
                    for (int y:map.get(x)){
                        if (dist[y] > dist[t] + 1){
                            dist[y] = dist[t] + 1;
                            queue.add(y);
                        }
                    }
                    map.remove(x);
                }
            }
        }
        return -1;
    }
}
