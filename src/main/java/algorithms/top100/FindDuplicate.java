package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/14.
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

 示例 1:

 输入: [1,3,4,2,2]
 输出: 2

 说明：

 不能更改原数组（假设数组是只读的）。
 只能使用额外的 O(1) 的空间。
 时间复杂度小于 O(n2) 。
 数组中只有一个重复的数字，但它可能不止重复出现一次。

 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] data = {1,3,4,2,2};
        System.out.println(findDuplicate(data));
    }

    /**
     * 双指针
     * 和找到链表环的入口类似
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int p = nums[0];
        int p1 = slow;//nums[slow]; 这里得注意  不要写为 nums[slow]
        while (p != p1){
            p = nums[p];
            p1 = nums[p1];
        }
        return p;
    }

    /**
     * 二分法实现
     * 关键：这道题的关键是对要定位的“数”做二分，而不是对数组的索引做二分。要定位的“数”根据题意在 11 和 nn 之间，每一次二分都可以将搜索区间缩小一半。
     * @param nums
     * @return
     */
    public static int findDuplicateB(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right)/2;
            int count = 0;
            for (int num:nums){
                if (num <= mid){
                    count++;
                }
            }
            if (count > mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
