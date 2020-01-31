package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/31.
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }

    /**
     * 贪心实现
     算法：
     该算法通用且简单：遍历数组并在每个步骤中更新：

     当前元素
     当前元素位置的最大和
     迄今为止的最大和
     主要是思考的问题 刚开始一直陷入 当前元素是否为正数，如果是负数则可能会断掉连续性， 之前的结果怎么处理等等， 很乱。。。。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int currentMax = nums[0];//当前最大值
        int result = nums[0];//最终最大值
        for (int i = 1; i < nums.length; i++){//这里从1开始的哦
            currentMax = Math.max(nums[i], currentMax + nums[i]);//注意比较的数据 是nums[i] 和 currentMax + nums[i]
            result = Math.max(currentMax, result);
        }
        return result;
    }


}
