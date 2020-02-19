package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/19.
 *718
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

 示例 1:

 输入:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 输出: 3
 解释:
 长度最长的公共子数组是 [3, 2, 1]。

 因为是子数组，所以要求是连续的
 */
public class FindLength {

    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        System.out.println(findLength(a,b));
    }

    /**
     * 逆序  leetcode执行快些
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B){
        int dp[][] = new int[A.length + 1][B.length + 1];
        int result = 0;
        for (int i = A.length - 1; i >= 0; i--){
            for (int j = B.length -1; j >= 0; j--){
                if (A[i] == B[j]){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    /**
     * 正序 处理
     * @param A
     * @param B
     * @return
     */
    public static  int findLength2(int[] A, int[] B) {
        int dp[][] = new int[A.length][B.length];
        int result = 0;
        for (int i = 0; i <= A.length - 1; i++){
            for (int j = 0; j <=  B.length -1; j++){
                if (A[i] == B[j]){
                    if (i - 1 < 0 || j - 1 < 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
