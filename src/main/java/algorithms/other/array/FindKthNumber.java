package algorithms.other.array;

/**
 * Created by yangyuan on 2021/2/28.
 * 668. 乘法表中第k小的数
 *
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？

 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。

 */
public class FindKthNumber {

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m*n;
        //二分
        while (l < r){
            int mid = (l + r) >> 1;
            if (get(m, n, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    //找到小于 mid 的数有多少个
    int get(int m, int n, int mid){
        int res = 0;
        for (int i = 1; i <=n; i++){
            res += Math.min(m, mid/i);
        }
        return res;
    }
}
