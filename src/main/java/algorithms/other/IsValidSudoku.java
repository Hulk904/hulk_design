package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/20.
 * 36
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

 */
public class IsValidSudoku {

    public static void main(String[] args) {

    }

    /**
     * 按照规则依次检查
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        boolean[] st = new boolean[9];
        //检查行
        for (int i = 0; i < 9; i++) {
            Arrays.fill(st,false);
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    int t = board[i][j] - '1';
                    if (st[t]) return false;//已经存在了
                    st[t] = true;
                }
            }
        }
        //检查列 跟上面一样  把i、j交换下

        for (int i = 0; i < 9; i++) {
            Arrays.fill(st,false);
            for (int j = 0; j < 9; j++){
                if (board[j][i] != '.'){
                    int t = board[j][i] - '1';
                    if (st[t]) return false;
                    st[t] = true;
                }
            }
        }
        //检查方格
        for (int i = 0; i < 9; i += 3){
            for (int j = 0; j < 9; j += 3){
                Arrays.fill(st, false);
                for (int x = 0; x < 3; x++){
                    for (int y = 0; y < 3; y++){
                        if (board[i + x][j + y] != '.'){
                            int t = board[i + x][y + j] - '1';
                            if (st[t]) return false;
                            st[t] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 超时  递归
     */

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0){
            return false;
        }
        return solve(board);
    }

    private boolean solve(char[][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++){
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';//复原现场
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++){
            if (board[i][col] != '.' && board[i][col] == c){
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c){
                return false;
            }
            if (board[3*(row/3) + i/3][3*(row/3) + i % 3] != '.'
                    && board[3*(row/3) + i/3][3*(row/3) + i % 3] == 'c'){
                return false;
            }
        }
        return true;
    }
}
