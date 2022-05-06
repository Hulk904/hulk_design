package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/7/11.
 * 978. 最长湍流子数组
 *
 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

 返回 A 的最大湍流子数组的长度。
 */
public class MaxTurbulenceSize {
    //dp
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        for (int i = 1, up = 1, down = 1; i < arr.length; i++){
            if (arr[i] > arr[i - 1]){
                up = down + 1;
                down = 1;
            } else if(arr[i] < arr[i - 1]){
                down = up + 1;
                up = 1;
            } else {
                down = 1;
                up = 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }
}
