package algorithms.other.array;

import java.util.PriorityQueue;

/**
 *
 * 871. 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。

 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。

 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。

 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。

 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。

 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。

 */
public class MinRefuelStops {
    //优先队列
    //
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int i = 0, n = stations.length, res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        while (startFuel < target) {
            while ( i < n && startFuel >= stations[i][0]){
                queue.add(stations[i++][1]);
            }
            if (queue.size() == 0) return -1;
            startFuel += queue.poll();
            res++;
        }
        return res;
    }

    //闫学灿  因为没有动态数组，需要多开辟一个数组，所以代码显得有点长
    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int res = 0, n = stations.length;
        int[][] s = new int[n + 1][2];
        for (int i = 0; i < n; i++){
            s[i][0] = stations[i][0];
            s[i][1] = stations[i][1];
        }
        s[n][0] = target;s[n][1] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int[] p:s){
            int x = p[0], y = p[1];
            while (queue.size() > 0 && startFuel < x){
                startFuel += queue.poll();
                res++;
            }
            if (startFuel < x) return -1;
            queue.add(y);
        }
        return res;
    }
}
