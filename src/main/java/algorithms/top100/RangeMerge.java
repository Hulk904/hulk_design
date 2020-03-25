package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangyuan on 2020/1/2.
 *
 *
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 跟会议室2类似，先按开始时间排序， 可以合并的区间必定是连续的。。。 然后进行合并
 */
public class RangeMerge {

    public static void main(String[] args) {
        int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(JSON.toJSONString(merge(data)));
    }

    public static int[][] mergeTimes2(int[][] intervals){
        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            if (result.size() > 0){
                int[] range = result.get(result.size() - 1);
                if (range[1] < intervals[i][0]){
                    result.add(intervals[i]);
                } else {
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
                }
            }else {
                result.add(intervals[i]);
            }
        }
        int[][] r = new int[result.size()][];
        for (int i = 0; i < result.size(); i++){
            r[i] = result.get(i);
        }
        return r;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(t -> t[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            if (result.size() > 0){
                if (intervals[i][0] <= result.get(result.size() - 1)[1]){//有交集
                    result.get(result.size() - 1)[1] = Math.max(intervals[i][1] , result.get(result.size() - 1)[1]);//注意 有可能是包含的关系
                } else {
                    result.add(intervals[i]);
                }
                continue;
            }
            result.add(intervals[i]);
        }
        int[][] data = new int[result.size()][];
        for (int i = 0; i < result.size(); i++){
            data[i] = result.get(i);
        }
        return data;
    }


}
