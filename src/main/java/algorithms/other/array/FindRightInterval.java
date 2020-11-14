package algorithms.other.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/10/25.
 *
 * 436. 寻找右区间
 *
 * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。

 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。

 */
public class FindRightInterval {

    /**
     * 排序  二分
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        for (int[] ins:intervals){
            int l = 0, r = intervals.length - 1;
            while (l < r){
                int mid = l + r >> 1;
                if (intervals[mid][0] >= ins[1]) r = mid;//中点的左端点 大于等于 当前区间右端点 说明答案在 左侧
                else l = mid + 1;
            }
            if (intervals[r][0] >= ins[1]) res[map.get(ins[0])]/*当前区间下标*/ = map.get(intervals[r][0]);
        }
        return res;
    }
}
