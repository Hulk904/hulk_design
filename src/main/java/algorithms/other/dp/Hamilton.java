package algorithms.other.dp;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/2/16.
 *
 * AcWing 91. 最短Hamilton路径
 *
 * 状态压缩dp
 */
public class Hamilton {

    int hamilton(int[][] graph, int n){
        int [][] f = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++){
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        f[1][0] = 0;
        for (int i = 1 ; i < (1 << n); i++){
            for (int j = 0 ; j < n ; j++){
                if (((i >> j) & 1) == 1){
                    for (int k = 0 ; k < n ; k ++){
                        if ((((i - (1 << j))>>k )& 1 ) == 1){
                            f[i][j] = Math.min(f[i][j], f[i - (1 << j)][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
        return f[(1 << n) -1 ][n-1];
    }

}
