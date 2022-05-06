package algorithms.other.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2021/5/22.
 * 857. 雇佣 K 名工人的最低成本
 * 有 N 名工人。 第 i 名工人的工作质量为 quality[i] ，其最低期望工资为 wage[i] 。

 现在我们想雇佣 K 名工人组成一个工资组。在雇佣 一组 K 名工人时，我们必须按照下述规则向他们支付工资：

 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 工资组中的每名工人至少应当得到他们的最低期望工资。
 返回组成一个满足上述条件的工资组至少需要多少钱。

 */
public class MincostToHireWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Pair[] q = new Pair[n];
        for (int i = 0; i < n; i++){
            q[i] = new Pair((wage[i] + 0.0)/quality[i], quality[i]);
        }
        Arrays.sort(q, (a, b) -> (int)((a.x - b.x)*100000));//少个0都不行
        double res = 1e10, sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a );
        for (Pair w:q){
            heap.add(w.y);
            sum += w.y;
            if (heap.size() > k){
                sum -= heap.poll();
            }
            if (heap.size() == k){
                res = Math.min(res, sum*w.x);
            }
        }
        return res;
    }

    class Pair{
        double x;
        int y;

        public Pair(double x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
