package algorithms.other.array;

/**
 * Created by yangyuan on 2021/2/28.
 * 667. 优美的排列 II
 *
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：

 ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.

 ② 如果存在多种答案，你只需实现并返回其中任意一种.

 */
public class ConstructArray {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        //前 n - k 个数是顺序放的，差值为1
        for (int i = 0; i < n - k - 1; i++) res[i] = i + 1;
        int u = n - k - 1;
        int i = n - k, j = n;
        //后面的 k个数交替存放 ，差值 依次 为 k, k - 1 ,k - 2 ...1
        while (u < n){
            res[u ++] = i ++;
            if (u < n) res[u++] = j --;
        }
        return res;
    }
}
