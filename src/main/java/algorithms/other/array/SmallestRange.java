package algorithms.other.array;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/12/20.
 *
 * 632. 最小区间
 *
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

 */
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[]{ 0, Integer.MAX_VALUE};
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++){
            heap.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (heap.size() > 0){
            int[] t = heap.poll();
            int l = t[0],  r = max;
            if (res[1] - res[0] > r - l){
                res = new int[]{l, r};
            }
            int i = t[1], j = t[2] + 1;
            if (j < nums.get(i).size()){
                heap.add(new int[]{nums.get(i).get(j), i , j});
                max = Math.max(max, nums.get(i).get(j));
            } else {
                break;
            }
        }
        return res;
    }
}
