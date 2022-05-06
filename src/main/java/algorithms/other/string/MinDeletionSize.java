package algorithms.other.string;

/**
 * Created by yangyuan on 2021/7/4.
 * 955. 删列造序 II
 *
 * 给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。

 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。

 比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。

 假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。

 **/

public class MinDeletionSize {
    //模拟题
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        boolean[] f = new boolean[n];
        int res = 0;
        for (int i = 0; i < m; i++){
            boolean flag = true;
            for (int j = 1; j < n; j++){
                if (!f[j] && strs[j - 1].charAt(i) > strs[j].charAt(i))
                    flag = false;
            }
            if (!flag) res++;
            else {
                for (int j = 1; j < n; j++){
                    if (!f[j] && strs[j - 1].charAt(i) < strs[j].charAt(i)){
                        f[j] = true;
                    }
                }
            }
        }
        return res;
    }
}
