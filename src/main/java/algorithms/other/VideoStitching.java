package algorithms.other;

/**
 * Created by yangyuan on 2020/4/13.
 * 1024. 视频拼接
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 */
public class VideoStitching {

    /**
     * 贪心去获取最远的距离 直到可以到达T
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {
        int e = 0;
        int count = 0;
        while (e < T){
            int dis= fast(e, clips);
            if (dis - e == 0) return -1;//不能在往前走了， 不能连续，终止
            e=dis;//不是e+=dis
            count++;
        }
        return count;
    }


    /**
     * 以 begin 开头  最远的覆盖最远的那个
     * @param begin
     * @param clips
     * @return
     */
    int fast (int begin, int[][] clips){
        int res = 0;
        for (int[] c:clips){
            if (c[0] <= begin && c[1] >= begin) res = Math.max(res, c[1]);
        }
        return res;
    }
}
