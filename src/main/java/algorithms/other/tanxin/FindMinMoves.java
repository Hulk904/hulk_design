package algorithms.other.tanxin;

/**
 * Created by yangyuan on 2020/11/15.
 *
 * 517. 超级洗衣机
 *
 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。

 在每一步操作中，你可以选择任意 m （1 ≤ m ≤ n） 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。

 给定一个非负整数数组代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回 -1。

 */
public class FindMinMoves {
    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int i:machines) sum += i;
        if (sum%n != 0) return -1;
        int avg = sum/n, left = 0, right = sum;
        int res = 0;
        for (int i = 0; i < n; i++){
            right -= machines[i];
            if (i > 0) left += machines[i - 1];
            int l = Math.max(avg*i - left, 0);
            int r = Math.max(avg*(n - i - 1) - right, 0);
            res = Math.max(res, l + r);
        }
        return res;
    }
}
