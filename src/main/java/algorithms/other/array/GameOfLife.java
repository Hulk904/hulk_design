package algorithms.other.array;

/**
 * Created by yangyuan on 2020/8/30.
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。


 */
public class GameOfLife {
    /**
     * 原数组中只有元素1，0 。32个bit位中只使用了最后位，所以可以复用其他位
     * 这里把结果放在倒数第二位，最后再移到最后返回结果
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m ;i ++){
            for (int j = 0; j < n; j++){
                int live = 0;
                for (int x = Math.max(0, i - 1); x <= Math.min(m - 1, i + 1); x++){
                    for (int y = Math.max(0, j - 1); y <= Math.min(n - 1, j + 1); y++){
                        if ((x != i || j != y) && (board[x][y]&1) == 1){
                            live++;
                        }
                    }
                }
                int cur = board[i][j] & 1;
                int next = 0;
                if (cur != 0){
                    if (live < 2 || live > 3) next = 0;
                    else next = 1;
                } else {
                    if (live == 3) next = 1;
                }

                board[i][j] = board[i][j] | (next<<1);
            }
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = board[i][j]>>1;
            }
        }
    }

}
