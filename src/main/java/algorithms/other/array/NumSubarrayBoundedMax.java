package algorithms.other.array;

/**
 * Created by yangyuan on 2021/4/28.
 * 795. 区间子数组个数
 *
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。

 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。

 这里的连续不是指数字连续，是指区间是连续的
 */
public class NumSubarrayBoundedMax {
    //把上下边界考虑为一个边界
    //一个边界就可以用双指针来求了
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return cal(A, R) - cal(A, L - 1);
    }

    //最大值小于等于k的集合个数
    int cal(int[] a, int k){
        int res = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] > k) continue;
            int j = i + 1;
            while (j < a.length && a[j] <= k) j++;
            int c = j - i;
            res += c*(c+1)/2;
            i = j;
        }
        return res;
    }
}
