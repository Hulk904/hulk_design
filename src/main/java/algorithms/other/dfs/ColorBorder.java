package algorithms.other.dfs;

/**
 * Created by yangyuan on 2021/12/11.
 * 1034. 边界着色
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 两个网格块属于同一 连通分量 需满足下述全部条件：
 两个网格块颜色相同
 在上、下、左、右任意一个方向上相邻
 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 在上、下、左、右任意一个方向上与不属于同一连通分量的网格块相邻
 在网格的边界上（第一行/列或最后一行/列）
 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。

 */
public class ColorBorder {
    int[][] grid;
    int[][] st;//0未搜过， 1：搜过， 2：搜过且是边界
    int n ;
    int m ;
    int[] dx = new int []{-1, 0 ,1, 0}, dy = new int[] {0, 1, 0, -1};

    void dfs(int x, int y){
        boolean border = false;
        for (int i = 0; i < 4; i++){
            int a = x + dx[i], b = y + dy[i];
            if (a >= 0 && a < n && b >= 0 && b < m && grid[a][b] == grid[x][y]){
                if (st[a][b] == 0){
                    st[a][b] = 1;
                    dfs(a, b);
                }
            } else {
                border = true;
            }
        }
        if (border) st[x][y] = 2;
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        st = new int[n][m];
        st[row][col] = 1;
        dfs(row, col);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (st[i][j] == 2){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
}
