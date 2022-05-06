package algorithms.other.array;

/**
 * Created by yangyuan on 2021/7/11.
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        //二路归并
        //但是并不需要显示找出0的位置（0作为分界点）
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0, j = n - 1, k = n - 1; i <= j;){
            if (nums[j]*nums[j] > nums[i]*nums[i]){
                res[k--] = nums[j]*nums[j];
                j--;
            } else {
                res[k--] = nums[i]*nums[i];
                i++;
            }
        }
        return res;
    }
}
