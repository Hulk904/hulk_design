package algorithms.other.array;

/**
 * Created by yangyuan on 2021/4/5
 * 778. 水位上升的泳池中游泳
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。

 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，
 但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，
 在你游泳的时候你必须待在坐标方格里面。

 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？

 */
public class SwimInWater {
    //flood fill &  二分
    int n;
    int[][] g;
    boolean[][] st;
    int [][] direct = new int[][]{{1,0},{-1,0},{0, 1},{0, -1}};
    public int swimInWater(int[][] grid) {
        g = grid;
        n = g.length;
        int l = 0, r = n*n - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }
    boolean check (int mid){
        if (g[0][0] > mid) return false;//这个不要漏了。除非dfs里面有检查
        st = new boolean[n][n];
        return dfs(0, 0, mid);
    }
    boolean dfs(int x, int y, int mid){
        if (x == n - 1 && y == n - 1) return true;
        st[x][y] = true;
        for (int i = 0; i < 4; i++){
            int a = x + direct[i][0];
            int b = y + direct[i][1];
            if (a >= 0 && a < n && b >= 0 && b < n && g[a][b] <= mid && !st[a][b]){
                if (dfs(a, b, mid)) return true;
            }
        }
        return false;
    }
}
