package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/20.
 * 724. 寻找数组的中心下标
 *
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。

 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。

 注意：中心下标可能出现在数组的两端。

 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        for (int i = 0, s = 0; i < nums.length; i++){
            if (s == sum - s - nums[i]) return i;
            s += nums[i];
        }
        return -1;
    }
}
