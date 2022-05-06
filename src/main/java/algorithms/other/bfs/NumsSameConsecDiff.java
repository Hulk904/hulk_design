package algorithms.other.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/7/10.
 * 967. 连续差相同的数字
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。

 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。

 你可以按 任何顺序 返回答案。


 */
public class NumsSameConsecDiff {
    int n, k;
    List<Integer> res  = new ArrayList();
    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        //枚举末尾数字
        for (int i = 1; i <= 9; i++){
            dfs(1, i);
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
    //
    void dfs(int u ,int x){
        if (u == n) res.add(x);
        else {
            //前面一个数是x ，则后面一位数是x+k, x- k, 分别去递归
            if ( x%10 - k >= 0) dfs(u + 1, x*10 + x%10 - k);
            if (k > 0 && x%10 + k < 10) dfs(u + 1, x*10 + x%10 + k);
        }
    }
}
