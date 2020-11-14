package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/10/24.
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

 */
public class EraseOverlapIntervals {

    /**
     *  1 按区间右端点从小到大排序
     *  2 从左到右选择区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int cur = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            //存在重复 跳过
            if (intervals[i][0] < cur){
                res++;
                continue;
            }
            cur = intervals[i][1];
        }
        return res;
    }
}
