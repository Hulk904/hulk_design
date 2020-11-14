package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/6.
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 A 。

 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。

 计算F(0), F(1), ..., F(n-1)中的最大值。

     a0    a1    a2   ...       an-2    an-1
     0      1    2              n - 2    n - 1
     1      2    3              n - 1    n-n   (当前减去上一层)    = a0 + a1 + ...+ an-1  - n*an-1
     2      3    4              n - n     1   （当前减去上一层）   = a0 + a1 +    + an-1  - n*an-2
     3      4    5              1         2

 */
public class MaxRotateFunction {

    public int maxRotateFunction(int[] A) {
        long sum = 0, cur = 0;
        for (int i:A) sum += i;
        int n = A.length;
        for (int i = 0; i < n; i++){
            cur += i*A[i];//第一行的值
        }
        long res = cur;
        for (int i = A.length - 1; i >= 0; i--){
            cur += sum - A.length*A[i];
            res = Math.max(res, cur);
        }
        return (int)res;
    }
}
