package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/11/14.
 * 506. 相对名次
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。

 (注：分数越高的选手，排名越靠前。)



 */
public class FindRelativeRanks {

    /**
     * 双关键字排序的问题
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[][] q = new int[n][2];
        for (int i = 0; i < nums.length; i++){
            q[i] = new int[]{nums[i], i};
        }
        Arrays.sort(q, (a, b) -> b[0] - a[0]);
        String [] res = new String[n];
        for (int i = 0; i < n; i++){
            int k = q[i][1];
            if (i == 0) res[k] = "Gold Medal";
            else if (i == 1) res[k] = "Silver Medal";
            else if (i == 2) res[k] = "Bronze Medal";
            else res[k] = "" + (i + 1);
        }
        return res;
    }
}
