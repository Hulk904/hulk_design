package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/13.
 * 827. 最大人工岛
 *
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。

 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）

 */
public class LargestIsland {
    int n, m;
    int[] p/*并查集*/, sz;// sz 每一个块大小
    int[][] dx = new int[][]{{-1, 0},{1, 0},{0, 1},{0, -1}};
    //并查集
    int find (int x){
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    //二维变一维坐标
    int get (int x, int y){
        return x*m + y;
    }

    public int largestIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        p = new int[m*n];
        sz = new int[m*n];
        for (int i = 0; i < m*n; i++){
            p[i] = i;
            sz[i] = 1;
        }
        int res = 1;
        //初始联通块合并
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j] > 0){
                    int a = get(i, j);
                    for (int k = 0; k < 4; k++){
                        int x = i + dx[k][0];
                        int y = j + dx[k][1];
                        if (x >= 0 && x < n && y>= 0 && y < m && grid[x][y] > 0){
                            int b = get(x, y);//新点坐标
                            int t1 = find(a), t2 = find(b);
                            if (t1 != t2){
                                sz[t2] += sz[t1];//新集合大小
                                p[t1] = t2;
                            }
                        }
                    }
                    res = Math.max(res, sz[find(a)]);
                }
            }
        }
        //枚举所有0， 得到新块的大小
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 0) {
                    Map<Integer, Integer> map = new HashMap();//存所有不同的连通块
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k][0];
                        int y = j + dx[k][1];
                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] > 0) {
                            int a = get(x, y);
                            map.put(find(a), sz[find(a)]);
                        }
                    }
                    int s = 1;
                    for (Map.Entry<Integer, Integer> en : map.entrySet()) s += en.getValue();
                    res = Math.max(res, s);
                }
        }
        return res;
    }
}





















