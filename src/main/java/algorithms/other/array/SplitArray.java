package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/18.
 * 410. 分割数组的最大值
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int l = 0;
        int r = 0;
        for (int i:nums){
            l = l > i ? l : i;
            r += i;
        }
        while (l < r){
            int mid = (l + r) >> 1;
            int temp = 0;
            int count = 1;
            for (int i:nums){
                temp += i;
                if (temp > mid){
                    count++;
                    temp = i;
                }
            }
            /*
            如果 cnt>m，说明划分的子数组多了，即我们找到的 mid 偏小，故 l=mid+1l=mid+1；
            否则，说明划分的子数组少了，即 mid 偏大(或者正好就是目标值)，故 h=midh=mid。
             */
            if (count > m){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
