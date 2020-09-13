package algorithms.other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/4/25.
 * 994. 腐烂的橘子
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：

 值 0 代表空单元格；
 值 1 代表新鲜橘子；
 值 2 代表腐烂的橘子。
 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

 */
public class OrangesRotting {

    int[][] direction = new int[][]{{-1, 0}, {0 ,1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    freshCount++;
                } else if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int times = 0;
        while (!queue.isEmpty()){
            times++;
            int n = queue.size();
            for (int i = 0; i < n; i++){
                int[] item = queue.poll();
                for (int[] dir:direction){
                    int x = item[0] + dir[0];
                    int y = item[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                            && grid[x][y] == 1){
                        grid[x][y] = 2;
                        freshCount--;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return freshCount == 0 ? Math.max(times - 1, 0) : -1;
    }

    /**
     * leetcode 上别人的。
     * while 循环里有count> 0 的条件，所以最后不需要对ans特殊处理。上面的实现会多计算一次。即最后一次只有出对没有入队的（通过count可以免去）
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});
                }
                if (r+1 < M && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }

}
