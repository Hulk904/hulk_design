package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/18.
 * 419. 甲板上的战舰
 *
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：

 给你一个有效的甲板，仅由战舰或者空位组成。
 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰


 */
public class CountBattleships {
    public int countBattleships(char[][] board) {
        //只记录左上角坐标   （该坐标上方和左方都没有 X  则是 左上角）
        int sum = 0;
        int m = board.length;
        int n = board[0].length;
        //统计左上角 个数
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i > 0 && board[i - 1][j] == 'X') continue;//排除x
                if (j > 0 && board[i][j - 1] == 'X') continue;//排除x
                if (board[i][j] == 'X') sum++;//目标x
                //如果是按照当前是x，并且左、和上不存在x的方式
            }
        }
        return sum;
    }


    /**
     * 思路在，但是不能很好的分解步骤，导致一直绕不出来
     * @param board
     * @return
     */
    public int countBattleshipsError(char[][] board) {
        int sum = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0){
                        sum++;
                        continue;
                    }
                    if (i - 1 >= 0 && board[i - 1][j] != 'X' && j - 1 >= 0 && board[i][j - 1] != 'X'){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
