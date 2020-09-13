package algorithms.other.array;

/**
 * Created by yangyuan on 2020/8/2.
 * 154. 寻找旋转排序数组中的最小值 II
 *
 * 注意数组中可能存在重复的元素。
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/154-find-minimum-in-rotated-sorted-array-ii-by-jyd/
 */
public class FindMin2 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + right >> 1;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else {
                right = right - 1;
            }
        }
        return nums[left];
    }

    //第二种思路就是 去重 + 二分了。。

}
