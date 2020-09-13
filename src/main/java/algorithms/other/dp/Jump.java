package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/6/25.
 *
 * 45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 */
public class Jump {

    public static void main(String[] args) {
        int[] array = {2,3,1,1,4};
        jump2(array);
    }

    /**
     * dp[i] 表示从i 到终点的最短距离
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1, j = 0; i < n ;i++){
            while (nums[j] + j < i) j++;
            dp[i] = dp[j] + 1;
        }
        return dp[n - 1];
    }

    public static int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
