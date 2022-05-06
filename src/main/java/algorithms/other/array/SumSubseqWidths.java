package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/6/5.
 * 891. 子序列宽度之和
 * 给定一个整数数组 A ，考虑 A 的所有非空子序列。

 对于任意序列 S ，设 S 的宽度是 S 的最大元素和最小元素的差。

 返回 A 的所有子序列的宽度之和。

 由于答案可能非常大，请返回答案模 10^9+7。

 */
public class SumSubseqWidths {
    int p[] = new int[20010];
    int MOD = 1000000007;
    //算两次
    //思路：计算每个元素对答案的贡献
    public int sumSubseqWidths(int[] A) {
        int n = A.length;
        p[0] = 1;
        //先对2^n次幂预处理
        for (int i = 1; i <= n; i++) p[i] = p[i - 1]*2%MOD;//前面一共有i个元素，选和不选所以是2^n 次方
        int res = 0;
        Arrays.sort(A);
        for (int i = 0; i < n; i++){
            res = (int)((res + A[i]*(long)p[i] - A[i]*(long)p[n - i - 1])%MOD);
        }
        return res;
    }
}
