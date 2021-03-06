package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/26.
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

 说明:
 不允许旋转信封。

 示例:

 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 输出: 3
 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

 一种思路，排序后转换为LIS（最长上升子序列）

 */
public class MaxEnvelopes {

    public static void main(String[] args) {
        int[][] data = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(data));
    }

    //todo 二分实现

    /**
     * 动态规划
     * @param envelopes
     * @return
     */
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1){
            return envelopes.length;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int result = 0;
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i],1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
