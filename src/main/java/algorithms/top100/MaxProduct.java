package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/9.
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

 示例 1:

 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。

 和最大和子序列类似。。 只是需要记录最小负数，有可能反过来
 */
public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(null == null);
        int[] data = {-4,-3,-2};
        System.out.println(maxProduct(data));

    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        int temp ;
        for (int i = 1; i < nums.length; i++){
            temp = max;
            max = Math.max(Math.max(nums[i], max*nums[i]), min*nums[i]);
            result = Math.max(result, max);
            min = Math.min(Math.min(nums[i], min*nums[i]), temp*nums[i]);
        }
        return result;
    }

}
