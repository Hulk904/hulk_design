package algorithms.other;

import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/10/17.
 * 407. 接雨水 II
 *
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 */
public class TrapRainWater {

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visit = new boolean[m][n];
        int[][] direc = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || i == m - 1 || j == 0|| j == n - 1){
                    visit[i][j] = true;
                    queue.add(new int[]{i, j, heightMap[i][j]});
                }
            }
        }
        int sum = 0;
        while (!queue.isEmpty()){
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++){
                int x = p[0] + direc[i][0];
                int y = p[1] + direc[i][1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y]){
                    if (heightMap[x][y] < p[2]){
                        sum += p[2] - heightMap[x][y];
                    }
                    visit[x][y] = true;
                    queue.add(new int[]{x, y, Math.max(heightMap[x][y], p[2])});
                }
            }
        }
        return sum;
    }
}
