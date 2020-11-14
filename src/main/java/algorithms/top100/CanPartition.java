package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/22.
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {

    public static void main(String[] args) {
        int[] data = {3,3,3,4,5};
        System.out.println(canPartition(data));
    }

    //01背包问题
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target + 1];

        dp[0]=true;
        for(int j = 0; j < nums.length; j++){
            //01背包 从大 到小 枚举体积
            for (int i = target; i >= 0; i--){
                if (i - nums[j] >= 0) {
                    dp[i] = dp[i] || dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
