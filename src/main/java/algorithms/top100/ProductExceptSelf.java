package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/13.
 *238
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 示例:

 输入: [1,2,3,4]
 输出: [24,12,8,6]
 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] data = {1,2,3,4};
        System.out.println(JSON.toJSONString(productExceptSelf(data)));
    }

    public static int[] productExceptSelfTimes2(int[] nums){
        int k = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = k;
            k*=nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i>= 0; i--){
            result[i]*=k;
            k*=nums[i];
        }
        return result;
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++){
            result[i] = nums[i - 1]*result[i - 1];
        }
        int k = 1;
        for (int i = nums.length - 2; i >= 0 ; i--){
            k=k*nums[i + 1];
            result[i] = result[i]*k;
        }
        return result;
    }

}
