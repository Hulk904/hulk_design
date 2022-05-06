package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/4/17.
 * 786. 第 K 个最小的素数分数
 *
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。

 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。

 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。

 */
public class KthSmallestPrimeFraction {

    double eps = 1e-8;
    int A;
    int B;

    int get(int[] arr, double mid){
        int res = 0;
        for (int i = 0, j = 0; i < arr.length; i++){
            while ((double)arr[j + 1]/arr[i] <= mid) j++;
            if ((double)arr[j]/arr[i] <= mid) res += j + 1;
            if (Math.abs((double)arr[j]/arr[i] - mid) < eps){
                A = arr[j];
                B = arr[i];
            }
        }
        return res;
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0, r = 1;
        while (r - l > eps){
            double mid = (l + r) /2;
            if (get(arr, mid) >= k) r = mid;
            else l = mid;
        }
        get(arr,r);
        return new int[]{A, B};
    }
}
