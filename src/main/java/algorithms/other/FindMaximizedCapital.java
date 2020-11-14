package algorithms.other;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/11/14.
 *
 * 502. IPO
 *
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。

 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。

 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。

 */
public class FindMaximizedCapital {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int[][] q = new int[Profits.length][2];
        int n = Profits.length;
        for (int i = 0; i < n; i++){
            q[i] = new int[]{Capital[i], Profits[i]};
        }
        Arrays.sort(q, (a,b) -> a[0] - b[0]);//根据成本由小到大排序
        Queue<Integer> h = new PriorityQueue<>((a,b) -> b - a);
        int i = 0;
        while (k-- > 0){
            while (i < n && q[i][0] <= W) {//可以开启的项目
                h.add(q[i][1]);
                i++;
            }
            if (h.isEmpty()) break;
            Integer t = h.poll();//选最大利润的
            W += t;
        }
        return W;
    }
}
