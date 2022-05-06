package algorithms.other.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/7/6.
 * 959. 由斜杠划分区域、
 *
 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。
 这些字符会将方块划分为一些共边的区域。

 （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

 返回区域的数目。
 */
public class RegionsBySlashes {
    //并查集
    int n;
    int[] p;
    int find(int x){
        if (x != p[x]){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    int get(int i, int j, int k){//转为一维 （每个块分为四个小块）
        return (i*n + j)*4 + k;
    }
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        p = new int[n*n*4];
        for (int i = 0; i < n*n*4; i++) p[i] = i;
        int[] dx = new int []{-1, 0, 1, 0}, dy = new int[] {0,1,0,-1};
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < 4 ;k++){
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < n){
                        p[find(get(i, j , k))] = find(get(x, y, k^2));
                    }
                    if (grid[i].charAt(j) != '/'){
                        p[find(get(i, j ,0))] = find(get(i,j ,1));
                        p[find(get(i, j ,2))] = find(get(i,j ,3));
                    }
                    if (grid[i].charAt(j) != '\\'){
                        p[find(get(i, j ,0))] = find(get(i,j ,3));
                        p[find(get(i, j ,2))] = find(get(i,j ,1));
                    }
                }
            }
        }
        Set<Integer> set = new HashSet();
        for (int i = 0; i < n*n*4; i++) set.add(find(i));
        return set.size();
    }
}
