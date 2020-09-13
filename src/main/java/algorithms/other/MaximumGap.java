package algorithms.other;

/**
 * Created by yangyuan on 2020/8/2.
 * 164. 最大间距
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

 如果数组元素个数小于 2，则返回 0。
 */
public class MaximumGap {

    private class Bucket{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i:nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        // 分配桶的长度和个数是桶排序的关键
        // 在 n 个数下，形成的两两相邻区间是 n - 1 个，比如 [2,4,6,8] 这里
        // 有 4 个数，但是只有 3 个区间，[2,4], [4,6], [6,8]
        // 因此，桶长度 = 区间总长度 / 区间总个数 = (max - min) / (nums.length - 1)

        int bucketNum = Math.max(1, (max - min)/(nums.length - 1));
        Bucket[] buckets = new Bucket[(max-min)/bucketNum + 1];
        for (int i =0 ;i <nums.length; i++){
            int loc = (nums[i] - min)/bucketNum;
            if (buckets[loc] == null){
                buckets[loc] = new Bucket();
            }
            buckets[loc].min = Math.min(buckets[loc].min, nums[i]);
            buckets[loc].max = Math.max(buckets[loc].max, nums[i]);
        }
        int previousMax = Integer.MAX_VALUE;
        int maxGat = Integer.MIN_VALUE;
        for(int i = 0; i <buckets.length; i++){
            if (buckets[i] != null && previousMax != Integer.MAX_VALUE){
                maxGat = Math.max(maxGat, buckets[i].min - previousMax);
            }
            if (buckets[i] != null){
                previousMax = buckets[i].max;
                maxGat = Math.max(maxGat, buckets[i].max - buckets[i].min);
            }
        }
        return maxGat;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] t = new int[]{3,6,9,1};
        maximumGap.maximumGap(t);

    }
}
