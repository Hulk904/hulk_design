package algorithms.other.dfs;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/6/21.
 * 37. 解数独
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 */
public class SolveSudoku {

    boolean row[][] = new boolean[9][9];
    boolean col[][] = new boolean[9][9];
    boolean cell[][][] = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i/3][j/3][t] = true;
                }
            }
        }
        dfs(board, 0 , 0);
     }

    boolean dfs (char[][] board, int x, int y){
        if (y == 9) {// 列到头了， 到下一行
            x++;
            y = 0;
        }
        if (x == 9) return true;
        if (board[x][y] != '.') return dfs(board, x , y + 1);//已经有数了，遍历下一个
        for (int i = 0; i < 9; i++){
            if (!row[x][i] && !col[y][i] && !cell[x/3][y/3][i]){//如果没冲突 则 处理。有冲突进行下一个，而不是直接return
                board[x][y] = (char)('1' + i);//填上当前位置
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = true;
                if (dfs(board, x , y + 1)) return true;
                board[x][y] = '.';//恢复现场
                row[x][i] = col[y][i] = cell[x/3][y/3][i] = false;
            }
        }
//        for (int i = 0; i < 9; i++){
//            if (row[x][i] || col[y][i] || q[x/3][y/3][i]){
//                return false;//这样写是不对的哦
//            }
//            board[x][y] = (char)('1' + i);
//            row[x][i] = col[y][i] = q[x/3][y/3][i] = true;
//            if (dfs(board, x, y + 1)){
//                return true;
//            }
//            row[x][i] = col[y][i] = q[x/3][y/3][i] = false;
//            board[x][y] = '.';
//        }
        return false;//最后都没找到解，说明当前分支无解
    }
}
