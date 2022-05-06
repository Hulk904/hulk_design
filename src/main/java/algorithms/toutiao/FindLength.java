package algorithms.toutiao;

import java.util.HashSet;
import java.util.Set;

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
    //动态规划  是 n2的复杂度  处理子序列 不错 ，这里可以用二分优化
    //
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


    /**
     * 字符串hash 实现 nlog(n)
     */
    int P = 131;
    int m, n;
    long[] ha, hb, p;
    long get(long[] h, int l, int r){
        return h[r] - h[l - 1]*p[r - l  + 1];
    }

    boolean check(int mid){
        Set<Long> set = new HashSet();
        for (int i = mid; i <= m; i++) set.add(get(ha, i - mid + 1, i));
        for (int i = mid; i <= n; i++){
            if (set.contains(get(hb, i - mid + 1, i))){
                return true;
            }
        }
        return false;
    }
    //字符串hash
    public int findLength3(int[] A, int[] B) {
        m = A.length;
        n = B.length;
        ha = new long[m + 1];
        hb = new long[n + 1];
        p = new long [m + 1];
        for (int i = 1; i <= m; i++) ha[i] = ha[i - 1]*P + A[i - 1];
        for (int i = 1; i <= n; i++) hb[i] = hb[i - 1]*P + B[i - 1];
        p[0] = 1;
        for (int i = 1;i <= m; i ++) p[i] = p[i - 1]*P;
        int l = 0, r = m;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid  -1;
        }
        return r;
    }
}
