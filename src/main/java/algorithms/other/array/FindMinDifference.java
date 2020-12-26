package algorithms.other.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/11/22.
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] time = new int[n];
        for(int i = 0; i < n; i++){
            time[i] = Integer.parseInt(timePoints.get(i).substring(0,2))*60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(time);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
            res = Math.min(res, time[i] - time[i - 1]);
        }
        return Math.min(res, 24*60 - time[n - 1] + time[0]);
    }
}
