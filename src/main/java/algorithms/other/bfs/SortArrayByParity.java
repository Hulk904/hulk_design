package algorithms.other.bfs;

/**
 * Created by yangyuan on 2021/6/12.
 * 905. 按奇偶排序数组
 *
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，
 * A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。
 */
public class SortArrayByParity {


    //比较简洁的写法
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            while ( l < r && nums[l]%2 == 0) l ++;
            while (l < r && nums[r]%2 == 1) r--;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }


    public int[] sortArrayByParityBad(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            while (l < nums.length && nums[l]%2 == 0)l++;
            while (r > 0 && nums[r]%2 == 1)r--;
            if (l < r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++; r--;
            }

        }
        return nums;
    }
}
