package algorithms.other.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/6/26.
 * 932. 漂亮数组
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：

 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。

 那么数组 A 是漂亮数组。

  

 给定 N，返回任意漂亮数组 A（保证存在一个）。

 */
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        if (n == 1) return new int[]{1};
        int[] left = beautifulArray((n + 1)/2);
        int[] right = beautifulArray(n/2);
        List<Integer> res = new ArrayList();
        for (int x:left) res.add(x*2 - 1);
        for (int x:right) res.add(x*2);
        int [] arr =  new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
