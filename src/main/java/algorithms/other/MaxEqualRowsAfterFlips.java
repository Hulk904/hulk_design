package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/12/25.
 * 1072. 按列翻转得到最大值等行数
 * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，
 * 单元格的值从 0 变成 1，或者从 1 变为 0 。

 回经过一些翻转后，行与行之间所有值都相等的最大行数。

 */
public class MaxEqualRowsAfterFlips {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map  = new HashMap();
        int res = 0;
        for (int i = 0; i< matrix.length; i++){
            String a = "",b = "";
            for (int x:matrix[i]){
                a += x;
                b += (1^x);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
            res = Math.max(res, Math.max(map.get(a), map.get(b)));
        }
        return res;
    }
}
