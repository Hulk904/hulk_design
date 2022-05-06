package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/5.
 * 798. 得分最高的最小轮调
 *
 * 给定一个数组 A，我们可以将它按一个非负整数 K 进行轮调，这样可以使数组变为 A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。

 例如，如果数组为 [2, 4, 1, 3, 0]，我们按 K = 2 进行轮调后，它将变成 [1, 3, 0, 2, 4]。这将记作 3 分，因为 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point]。

 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调索引 K。如果有多个答案，返回满足条件的最小的索引 K。



 */
public class BestRotation {
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] b = new int [n + 1];
        for (int i = 0; i < A.length; i++){
            int l = i - A[i] + 1,  r = i;
            if (l >= 0) {
                b[l]++;
                b[r + 1]--;
            } else {
                b[0]++;
                b[r + 1]--;
                b[l + n] ++;
                b[n]--;
            }
        }
        int res = Integer.MAX_VALUE, k = 0;
        for (int i = 0, sum = 0; i < n; i++){
            sum += b[i];
            if (res > sum){
                res = sum;
                k = i;
            }
        }
        return k;
    }

}
