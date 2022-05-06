package algorithms.other.array;

/**
 * Created by yangyuan on 2021/2/28.
 * 665. 非递减数列
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

 */
public class CheckPossibility {

    boolean check(int[] nums){
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < nums[i - 1]){
                return false;
            }
        }
        return true;
    }

    public boolean checkPossibility(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            //遇到逆序，做两次改变：分别改为小的， 和分别改为大的，然后分别判断是不是递增序列
            if (nums[i] < nums[i - 1]){
                int a = nums[i - 1];
                int b = nums[i];
                nums[i - 1] = a;
                nums[i] = a;
                if (check(nums)) return true;
                nums[i - 1] = b;
                nums[i] = b;
                if (check(nums)) return true;
                return false;
            }
        }
        return true;
    }

    public boolean checkPossibility2(int[] nums){
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                count ++;
            }
        }
        return count <= 1;
    }
}
