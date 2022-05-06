package algorithms.other.array;

/**
 * Created by yangyuan on 2021/5/30.
 * 883. 三维形体投影面积
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。

 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。

 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。

 投影就像影子，将三维形体映射到一个二维平面上。

 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。

 返回所有三个投影的总面积。

 */
public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++){
            int r = 0, c = 0;
            for (int j = 0; j < n; j++){
                if (grid[i][j] > 0) res ++;
                r = Math.max(r, grid[i][j]);
                c = Math.max(c, grid[j][i]);
            }
            res += r + c;
        }
        return res;
    }
}
