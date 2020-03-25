package algorithms.top100;

/**
 * Created by yangyuan on 2020/1/21.
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

 */
public class FindTargetSumWays {

    private Integer count = 0;


    public static void main(String[] args) {
        int[] data = {1,2,1};
        System.out.println(new FindTargetSumWays().findTargetSumWays(data, 0));
    }

    /**
     * 转换成01背包问题  存在和为target的数组  https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-ji-bai-liao-98de-javayong-hu-by-r/
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if ((sum -S)%2 == 1 || S > sum){//不可能有结果
            return 0;
        }
        int target = (sum -S)/2;//  写成(sum + S) / 2; 更好理解 。 可能开的空间比较大些
        int[] dp = new int[target + 1];

//        for (int i = 0; i <= target; i++){  //为什么这种遍历方式不行 ？ 跟dp[0] = 1的初始化值有关？？？
//            for (int j = nums.length - 1; j >= 0; j--){
//                if (i - nums[j] >= 0) {
//                    dp[i] += dp[i - nums[j]];
//                }
//
//            }
//        }
        //跟完全背包问题不同的一点是它要求完全装满，所以dp[0]要特殊初始化
        dp[0] = 1;
        for (int num:nums){
            for (int i = target; i >= num; i--){
                //目标都是target所以是累加计算。。。
                dp[i] += dp[i -num];
            }
        }
        return dp[target];
    }

    /**
     * 转换为求目标和，回溯的性能比上面慢不少。。
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S){
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++){
            totalSum+=nums[i];
        }
        if (((totalSum + S)&1) == 1) return 0;
        dfs(nums, 0, totalSum + S >> 1);
        return count;
    }

    void dfs(int[] nums, int index, int reside){
        if (reside < 0){
            return;
        }
        if (reside == 0){
            count++;
            //return;
        }
        for(int i = index; i < nums.length; i++){
            dfs(nums, i + 1, reside - nums[i]);
        }
    }

    public int findTargetSumWaysIter(int[] nums, int S) {
        sum(nums, 0, 0, S);
        return count;
    }

    /**
     * 递归实现
     *
     * 关键记住怎么去用代码表达出这个递归的思想，参数不好弄啊。
     *
     *可以看看最后面自己写的时候错误的表达。。。
     * @param nums
     * @param cur
     * @param sum
     * @param target
     */
    private void sum(int[] nums,int cur, int sum, int target){
//        if (sum == target){ //这里判断 结果可能还没有计算完呢。。 比如 1，1，1  sum = 1。 可能 只算到第一个1时就结束了
//            count++;
//        }
        if (cur >=nums.length){
            if (sum == target){
                count++;
            }
            return;
        }
        sum(nums, cur+1, sum + nums[cur], target);
        sum(nums, cur+1, sum - nums[cur], target);
    }



//    private void sum(int[] nums,int cur){
//        if (cur < 0){
//            return ;
//        }
//        curSum += nums[cur];
//        sum(nums,cur + 1);
//        if (curSum == sum){
//            count++;
//        }
//        int b = sum(nums, cur - 1) - nums[cur];
//        if (b == sum){
//            count++;
//        }
//
//    }


}
