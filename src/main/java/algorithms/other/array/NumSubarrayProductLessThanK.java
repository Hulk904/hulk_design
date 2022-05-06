package algorithms.other.array;

/**
 * Created by yangyuan on 2021/3/14.
 *
 * 713. 乘积小于K的子数组
 *
 * 给定一个正整数数组 nums。

 找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class NumSubarrayProductLessThanK {

    //多简洁
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int res = 0, p = 1;
        for (int i = 0, j = 0; i < nums.length; i++){
            p *= nums[i];
            while(j <= i && p >= k) p/= nums[j++];
            res += i - j + 1;
        }
        return res;

    }


    //自己的双指针  还是错的。
    public int numSubarrayProductLessThanKError(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            int j = i;
            int ji = nums[j--];
            if (ji > k) continue;
            while (j >= 0 && ji <= k){
                ji *= nums[j--];
                System.out.println(ji);
            }
            System.out.println(i + "  " + j);
            res += i - j;
        }
        return res;
    }


}
