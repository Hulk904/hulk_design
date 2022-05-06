package algorithms.other.tanxin;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/12/5.
 * 1029. 两地调度
 公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a
 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。

 返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。

 */
public class TwoCitySchedCost {
    //贪心
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        int n = costs.length/2;
        int res = 0;
        for (int i = 0; i < n; i++ ) res += costs[i][0];
        for (int i = n; i < n*2; i++) res += costs[i][1];
        return res;
    }
}
