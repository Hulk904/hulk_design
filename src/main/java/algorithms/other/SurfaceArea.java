package algorithms.other;

/**
 * Created by yangyuan on 2020/4/25.
 *
 * 892. 三维形体的表面积
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。

 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。

 请你返回最终形体的表面积。

 */
public class SurfaceArea {

    /**
     * 首先，一个柱体一个柱体的看，每个柱体是由：2 个底面（上表面/下表面）+ 所有的正方体都贡献了 4 个侧表面积。
     然后，把柱体贴合在一起之后，我们需要把贴合的表面积给减掉，两个柱体贴合的表面积就是 两个柱体高的最小值*2
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int res = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int level = grid[i][j];
                if (level > 0){
                    res += (level<<2) + 2;
                    //只需要处理两个方向的重叠区域：左侧和上面
                    res -= (i > 0) ? Math.min(level, grid[i - 1][j])<<1 : 0;//重叠部分需要乘以2
                    res -= (j > 0) ? Math.min(level, grid[i][j - 1])<<1 : 0;
                }
            }
        }
        return res;
    }
}
