package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/2.
 * 282. 石子合并
 * 设有N堆石子排成一排，其编号为1，2，3，…，N。

 每堆石子有一定的质量，可以用一个整数来描述，现在要将这N堆石子合并成为一堆。

 每次只能合并相邻的两堆，合并的代价为这两堆石子的质量之和，合并后与这两堆石子相邻的石子将和新堆相邻，合并时由于选择的顺序不同，合并的总代价也不相同。

 例如有4堆石子分别为 1 3 5 2， 我们可以先合并1、2堆，代价为4，得到4 5 2， 又合并 1，2堆，代价为9，得到9 2 ，再合并得到11，总代价为4+9+11=24；

 如果第二步是先合并2，3堆，则代价为7，得到4 7，最后一次合并代价为11，总代价为4+7+11=22。

 问题是：找出一种合理的方法，使总的代价最小，输出最小代价。



 区间dp
 */
public class RockMerge {

    public static void main(String[] args) {
        int[] nums = {1,3,5,2};
        System.out.println(rockMerge(nums));
    }

    public static int rockMerge(int[] nums){
        int[][] dp = new int[nums.length  + 1][nums.length + 1];

        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int len = 2; len <= nums.length; len++){//区间长度
            for (int j = 1; j <= nums.length - len + 1; j++){//起点
                //区间长度和起点都确定了，所以左端点和右端点可以计算出来了
                int l = j, r = j + len - 1;//最少两堆所以r的区间是 j+len-1
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++){
                    //首先抛开最后一步 （因为每种合并最后一步都是区间里的所有和） 这样
                    //最后一步代价是sum[r] - sum[l - 1]，状态转移方程就是下面
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + sum[r] - sum[l - 1]);
                }
            }
        }
        return dp[1][nums.length];
    }

}
