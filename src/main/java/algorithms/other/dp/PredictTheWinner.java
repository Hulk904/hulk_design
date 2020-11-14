package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/11/8.
 * 486. 预测赢家
 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

 */
public class PredictTheWinner {

    /**
     * 经典区间dp
     * @param nums
     * @return
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];//dp[i][j] 表示i，j区间  你的分数减对手分数最大值
        for (int len = 1; len <= n; len++){//注意枚举顺序，  先枚举长度   再循环左端点
            for (int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                if (len == 1) dp[i][j] = nums[i];//边界情况，就等于nums[i]自己
                else {
                    //dp[i+1][j], dp[i][j - 1] 都表示对手分数减你的分数 。 取反加上我们选取的(i或j)就是 dp[i][j]
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n -1] >= 0;
    }
}
