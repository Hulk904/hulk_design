package algorithms.other.array;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by yangyuan on 2021/5/12.
 * 826. 安排工作以达到最大收益
 *
 * 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。

 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。

 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。

 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。

 我们能得到的最大收益是多少？

 */
public class MaxProfitAssignment {
    public int maxProfitAssignmentError(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++){
            map.put(difficulty[i], profit[i]);
        }
        Arrays.sort(worker);
        int res = 0, p = 0;
        for (int i = 0; i < worker.length; i++){
             Integer max = map.floorKey(worker[i]);
            if (max != null){
                p = Math.max(p, map.get(max));//这里的p可能不是最大值（难度更底但是利润更大的可能错过了。 还是需要遍历value取最大值）
                res += p;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfitAssignment maxProfitAssignment = new MaxProfitAssignment();
        int[]diff = {2,4,6,8,10};
        int[]profit = {10,20,30,40,50};
        int[] wor = {4,5,6,7};
        maxProfitAssignment.maxProfitAssignment(diff, profit, wor);
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Task[] tasks = new Task[difficulty.length];
        for (int i = 0; i < difficulty.length; i++){
            tasks[i] = new Task(difficulty[i], profit[i]);
        }
        Arrays.sort(tasks, (a, b) -> a.diff - b.diff);
        Arrays.sort(worker);
        int res = 0, p = 0;
        for (int i = 0, j = 0; i < worker.length; i++){
            while (j < tasks.length && tasks[j].diff <= worker[i]){
                p = Math.max(p, tasks[j++].prof);
            }
            res += p;
        }
        return res;
    }

    class Task{
        int diff;
        int prof;

        public Task(int diff, int prof){
            this.diff = diff;
            this.prof = prof;
        }
    }

}
