package algorithms.other.array;

/**
 * Created by yangyuan on 2020/9/12.
 * 303. 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 *
 */
public class NumArray {

    int[] sum ;

    /**
     * 让下标从1开始。不然处理 0～ k区间的会麻烦点。 因为他们都是闭区间,不然sum[0] 包含了第一个元素
     * @param nums
     */
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[++j] - sum[i];
    }
}
