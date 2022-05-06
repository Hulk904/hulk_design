package algorithms.other.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2022/1/1.
 * 1091. 二进制矩阵中的最短路径
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。

 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：

 路径途经的所有单元格都的值都是 0 。
 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 畅通路径的长度 是该路径途经的单元格总数。

 */
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //flood fill
        //最短路 只能bfs，不能dfs
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        int[][] dist = new int[n][n];
        dist[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int dx[] = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int dy[] = new int[]{-1, 0, 1, 1 ,1 , 0, -1, -1};
        while (q.size() > 0){
            int[] t = q.poll();
            for (int i = 0; i < 8; i ++){
                int x = t[0] + dx[i];
                int y = t[1] + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && dist[x][y] == 0){
                    dist[x][y] = dist[t[0]][t[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        return dist[n - 1][n - 1] == 0 ? -1 : dist[n - 1][n - 1];
    }
}
