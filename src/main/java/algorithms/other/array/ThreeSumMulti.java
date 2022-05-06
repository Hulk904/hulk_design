package algorithms.other.array;

/**
 * Created by yangyuan on 2021/6/19.
 * 923. 三数之和的多种可能
 *
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。

 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。

 */
public class ThreeSumMulti {
    int MOD = 1000000007;
    int cnt[] =  new int[310];
    public int threeSumMulti(int[] arr, int target) {
        for (int x:arr) cnt[x]++;
        int res = 0;
        for (int i = 0; i<= target; i++){
            for (int j = i; j <= target - i - j; j++){
                res = (res + calc(i, j, target - i - j))%MOD;
            }
        }
        return res;
    }
    //求组合数
    long C (int a, int b){
        long res = 1;
        for (int i = a, j = 1; j <= b; i--, j++){
            res = res*i/j;
        }
        return res%MOD;
    }
    int calc(int a, int b, int c){
        if (a == b && b == c) return (int)C(cnt[a], 3);//三数相同
        if (a == b) return (int)(C(cnt[a], 2)*cnt[c]%MOD);
        if (b == c) return (int)(cnt[a]*C(cnt[b], 2)%MOD);
        return (int)(cnt[a]*cnt[b]*cnt[c]%MOD);
    }
}
