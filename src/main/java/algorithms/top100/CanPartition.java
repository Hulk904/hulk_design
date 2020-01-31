package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/22.
 */
public class CanPartition {

    public static void main(String[] args) {
        int[] data = {3,3,3,4,5};
        System.out.println(canPartition(data));
    }

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
        //下面这个初始化有没有好像都行啊
        if (nums[0] <= target){
            dp[nums[0]] = true;
        }
        for(int j = 1; j < nums.length; j++){
            for (int i = target; i >= 0; i--){
                if (i - nums[j] >= 0) {
                    dp[i] = dp[i] || dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
