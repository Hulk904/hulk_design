package algorithms.top100;

/**
 * Created by yangyuan on 2021/3/14.
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。

 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。

 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)

 */
public class MaxAreaOfIsland {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0 , -1};
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int i, int j){
        if (grid[i][j] == 0) return 0;
        int res = 1;
        grid[i][j] = 0;
        for (int t = 0; t < 4; t++){
            int x = i + dx[t];
            int y = j + dy[t];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 ){
                res += dfs(x, y);
            }
        }
        return res;
    }
}
