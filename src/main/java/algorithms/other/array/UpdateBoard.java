package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/21.
 *
 * 529. 扫雷游戏
 *
 * 让我们一起来玩扫雷游戏！

 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻
 （上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
 'X' 则表示一个已挖出的地雷。

 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 如果在此次点击中，若无更多方块可被揭露，则返回面板。

 */
public class UpdateBoard {
    int m ;
    int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    void dfs(char[][] board, int x, int y){
        if (board[x][y] != 'E') return;
        int s = 0;
        //
        for (int i = Math.max(x - 1, 0); i <= Math.min(m - 1, x + 1); i++){
            for (int j = Math.max(y - 1, 0); j <= Math.min(n - 1, y + 1); j++){
                if (i != x || j != y){//注意周围八个方块遍历的条件   不是i != j
                    if (board[i][j] == 'M' || board[i][j] == 'X'){//是地雷 （已挖出、未挖出）
                        s++;
                    }
                }
            }
        }
        if (s > 0){
            board[x][y] = (char)('0' + s);//周围有地雷则 改值 然后推出
            return;
        }
        board[x][y] = 'B';//周围没有地雷，递归周围的八个方块

        for (int i = Math.max(x - 1, 0); i <= Math.min(m - 1, x + 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(n - 1, y + 1); j++) {
                if (i != x || j != y) {
                    dfs(board, i, j);
                }
            }
        }
    }
}
