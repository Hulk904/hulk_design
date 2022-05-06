package algorithms.toutiao;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/17.
 *673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。  注意这里要求的LIS的个数哦  与300不同

 示例 1:

 输入: [1,3,5,4,7]
 输出: 2
 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。

 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        int [] data = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(data));
    }

    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int [nums.length];//以i结尾的最长上升子序列长度
        int[] length = new int[nums.length];//以i结尾最长上升子序列个数
        Arrays.fill(dp, 1);
        Arrays.fill(length, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < i; j ++){
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        length[i] = length[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        length[i] += length[j];
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++){ //可以优化进 上面里面，边循环边计算
            if ( dp[i] == result){//可能有多个长度一样的，所以不能找到一个就返回了
                count+=length[i];
            }
        }
        return  count;

    }

    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];//以i结尾的最长上升子序列长度
        int cnt[] = new int[n];//以i结尾最长上升子序列个数
        int maxl = 0 ,res = 0;
        for (int i = 0; i < n; i++){
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i ;j++){
                if (nums[j] <nums[i]){
                    if (dp[i] <= dp[j]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[i] == dp[j] + 1){
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (maxl < dp[i]) {
                maxl = dp[i];
                res = cnt[i];
            } else if (maxl == dp[i]){
                res += cnt[i];
            }
        }
        return res;
    }
}
