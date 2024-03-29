package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/10.
 * 1014. 最佳观光组合
 *
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 返回一对观光景点能取得的最高分。

 示例：

 输入：[8,1,5,2,6]
 输出：11
 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11

 https://leetcode-cn.com/problems/best-sightseeing-pair/solution/python-jie-fa-by-jiayangwu/

 */
public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        int[] data = {3,7,2,3};
        System.out.println(maxScoreSightseeingPair(data));
    }

    //Vi + Vj + i - j (i 在前j在后) 最大
    //Vi + i + (Vj - j)  枚举j的时候 相当于 需要前面的 Vi + i 最大

    public static  int maxScoreSightseeingPair(int[] A) {
        int result = 0;
        int preMax = A[0];
        for (int i = 1; i < A.length; i++){
            result = Math.max(result, preMax + A[i] - i);
            preMax = Math.max(preMax, A[i] + i);
        }
        return result;
    }


}
