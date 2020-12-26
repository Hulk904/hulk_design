package algorithms.other.array;

import java.util.Random;

/**
 * Created by yangyuan on 2020/11/21.
 * 528. 按权重随机选择
 *
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。

 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。

 */
public class PickIndex {
    int[] sum;

    public PickIndex(int[] w) {
        //转换为一维情况 ， 前缀和
        sum = new int[w.length + 1];
        for (int i = 1;i <= w.length; i++){
            sum[i] = sum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int n = sum.length;
        int x = new Random().nextInt(sum[n - 1]) + 1;
        int l = 0, r = n;
        while (l < r){
            int mid = l + r >> 1;
            if (sum[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return l - 1;
    }
}
