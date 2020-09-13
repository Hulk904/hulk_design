package algorithms.other.dfs;

/**
 * Created by yangyuan on 2020/7/25.
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solve {

    int m;
    int n;
    char[][] board;
    int dx[][] = new int [][]{{0, -1},{1, 0},{0, 1},{-1, 0}};

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][n - 1] == 'O') dfs(i, n -1);
        }
        for (int i = 0; i < n; i++){
            if (board[0][i] == 'O') dfs(0, i);
            if (board[m - 1][i] == 'O') dfs(m - 1, i);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] =='#') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j){
        board[i][j] = '#';
        for (int k = 0; k < dx.length; k++){
            int a = i + dx[k][0];
            int b = j + dx[k][1];
            if (a >=0 && a <m && b >= 0 && b < n && board[a][b] == 'O'){
                dfs(a,b);
            }
        }
    }
}
