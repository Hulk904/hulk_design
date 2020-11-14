package algorithms.other.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/10/18.
 */
public class PacificAtlantic {

    int[][] matrix;
    int[][] st;
    int m;
    int n;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        if (m == 0) return new ArrayList<>();
        this.n = matrix[0].length;
        if (n == 0) return new ArrayList<>();
        st = new int[m][n];
        for (int i = 0; i < m; i++) dfs(i, 0 ,1);
        for (int i = 0; i < n; i++) dfs(0, i, 1);
        for (int i = 0; i < m; i++) dfs(i, n - 1, 2);
        for (int i = 0; i< n; i++) dfs(m - 1, i, 2);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (st[i][j] == 3){
                    List<Integer> item = new ArrayList();
                    item.add(i);
                    item.add(j);
                    res.add(item);
                }
            }
        }
        return res;
    }

    void dfs(int x, int y, int t){
        if ((st[x][y] & t) > 0 ) return;//已经访问过x，y
        st[x][y] |= t;
        for (int i = 0; i < 4; i++){
            int a = x + direction[i][0];
            int b = y + direction[i][1];
            if (a >= 0 && a < m && b >= 0 && b < n && matrix[a][b] >= matrix[x][y]){
                dfs(a, b, t);
            }
        }
    }
}
