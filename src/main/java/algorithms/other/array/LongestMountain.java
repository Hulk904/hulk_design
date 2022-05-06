package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/5/16.
 *845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

 B.length >= 3
 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 （注意：B 可以是 A 的任意子数组，包括整个数组 A。）

 给出一个整数数组 A，返回最长 “山脉” 的长度。

 如果不含有 “山脉” 则返回 0。

 */
public class LongestMountain {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] l = new int[n], r = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for (int i = 1; i < n; i++){
            if (arr[i] > arr[i - 1]){
                l[i] = l[i - 1] + 1;
            }
        }
        for (int i = n - 2; i>= 0; i--){
            if (arr[i] > arr[i + 1]){
                r[i] = r[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            if (l[i] > 1 && r[i] > 1){
                res = Math.max(res, l[i] + r[i] - 1);
            }
        }
        return res;
    }
}
