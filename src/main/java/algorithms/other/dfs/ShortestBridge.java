package algorithms.other.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangyuan on 2021/6/26.
 * 934. 最短的桥

 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）

 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。

 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。）

 */
public class ShortestBridge {
    int m,n;
    int[][] grid, dist;
    Queue<Pair> queue = new LinkedList();
    int[][] direc = new int[][]{{-1,0},{0, -1},{1, 0},{0, 1}};

    void dfs(int x, int y){
        grid[x][y] = 0;
        dist[x][y] = 0;
        queue.add(new Pair(x, y));//不要写到下面的if 里面了
        for (int i = 0; i < 4; i++){
            int a = x + direc[i][0], b = y + direc[i][1];
            if (a >= 0 && a < m && b >= 0 && b < n && grid[a][b] > 0){
                dfs(a, b);
            }
        }
    }

    int bfs(){
        while(queue.size() > 0){
            Pair t = queue.poll();
            for (int i = 0; i < 4; i++){
                int x = t.x + direc[i][0], y = t.y + direc[i][1];
                if (x >= 0 && x < m && y >=0 && y < n && dist[x][y] > dist[t.x][t.y] + 1){
                    dist[x][y] = dist[t.x][t.y] + 1;
                    if (grid[x][y] > 0) return dist[x][y] - 1;
                    queue.add(new Pair(x, y));//别忘了加如新节点
                }
            }
        }
        return -1;
    }
    // dfs + bfs
    public int shortestBridge(int[][] A) {
        //多源最短路
        grid = A;
        m = grid.length;
        n = grid[0].length;
        dist = new int[m][n];
        for (int i= 0; i < m; i++){
            Arrays.fill(dist[i], (int) 1e8);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] > 0){
                    dfs(i,j);
                    return bfs();
                }
            }
        }
        return -1;
    }
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}






















