package algorithms.top100;

/**
 * Created by yangyuan on 2020/4/17.
 * 面试题03. 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。

 */
public class FindRepeatNumber {


    /**
     * 1、没有空间限制也可以使用HashSet来实现
     * 2、这个跟FindDuplicate（只有一个不同的元素） 还不一样，所以不能使用二分来做。。
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
