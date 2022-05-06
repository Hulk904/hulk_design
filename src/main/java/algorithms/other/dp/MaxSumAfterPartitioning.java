package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/12/18.
 * 1043. 分隔数组以得到最大和
 *
 * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。

 返回将数组分隔变换后能够得到的元素最大和。

  

 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。

 *
 */
public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //线性dp
        int n = arr.length;
        int[] dp = new int[n + 1];//i 结尾长度最大为k的 最大和
        for (int i = 1; i <= n; i++){
            for (int j = 1, v = 0; j <= k && j <= i; j++){//v 表示 后j个元素中的最大值。(长度为j)
                v = Math.max(v, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + v*j);
            }
        }
        return dp[n];
    }
}
