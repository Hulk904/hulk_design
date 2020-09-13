package algorithms.other.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/6/27.
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 */
public class Insert {



    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int k = 0;
        while (k < intervals.length && intervals[k][1] < newInterval[0]) res.add(intervals[k++]);//左边完全没交集的部分
        if (k < intervals.length){//有交集部分
            newInterval[0] = Math.min(newInterval[0], intervals[k][0]);
            while (k < intervals.length && intervals[k][0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], intervals[k++][1]);
            }
        }
        res.add(newInterval);
        while (k < intervals.length) res.add(intervals[k++]);
        int[][] r= new int[res.size()][];
        for (int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
