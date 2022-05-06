package algorithms.other.array;

/**
 * Created by yangyuan on 2021/6/19.
 * 922. 按奇偶排序数组 II
 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 你可以返回任何满足上述条件的数组作为答案。
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0,j = 1; i < nums.length && j < nums.length; i+=2, j+=2){
            while (i < nums.length && nums[i]%2 == 0) i+=2;
            while (j < nums.length && nums[j]%2 == 1) j+=2;
            if (i < nums.length) {//注意这里不是 i< j 他两没关系
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
