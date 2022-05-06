package algorithms.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yangyuan on 2021/11/20.
 * 1001. 网格照明
 * 在 N x N 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。

 数组 lamps 表示打开的灯的位置。lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 的第 i 盏灯 。每盏灯都照亮自身单元格以及同一行、同一列和两条对角线上的所有其他单元格。

 查询数组 queries 中，第 i 次查询 queries[i] = [rowi, coli]，如果单元格 [rowi, coli] 是被照亮的，则查询结果为 1 ，否则为 0 。在第 i 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowi][coli] 上或其相邻 8 个方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。

 返回答案数组 ans ， answer[i] 应等于第 i 次查询 queries[i] 的结果，1 表示照亮，0 表示未照亮。

 */
public class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        // 分别记录 横竖斜方向 亮灯情况
        // 斜着的分别是 x - y, x + y 为固定值 类似八皇后记录状态
        Map<Integer, Set<Integer>> row = new HashMap(), col = new HashMap(), dg = new HashMap(), udg = new HashMap();
        for (int[] p:lamps){
            int x = p[0], y = p[1];
            if (row.get(x) == null){
                row.put(x ,new HashSet());
            }
            row.get(x).add(y);
            if (col.get(y) == null){
                col.put(y, new HashSet());
            }
            col.get(y).add(x);
            if (dg.get(y - x) == null){
                dg.put(y - x, new HashSet());
            }
            dg.get(y - x).add(x);
            if (udg.get(x + y) == null){
                udg.put(x + y, new HashSet());
            }
            udg.get(x + y).add(x);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int x = queries[i][0], y = queries[i][1];
            if ((row.get(x) != null && row.get(x).size() > 0)||
                    (col.get(y) != null && col.get(y).size() > 0) ||
                    (dg.get(y - x) != null && dg.get(y - x).size() > 0) ||
                    (udg.get(x + y) != null && udg.get(x + y).size() > 0)){
                res[i] = 1;
                for (int m = x - 1; m <= x + 1; m++){
                    for (int t = y - 1; t <= y + 1; t++){
                        if (row.get(m) != null){
                            row.get(m).remove(t);
                        }
                        if (col.get(t) != null){
                            col.get(t).remove(m);
                        }
                        if (dg.get(t - m) != null){
                            dg.get(t - m).remove(m);
                        }
                        if (udg.get(t + m) != null){
                            udg.get(t + m).remove(m);
                        }
                    }
                }
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }
}
