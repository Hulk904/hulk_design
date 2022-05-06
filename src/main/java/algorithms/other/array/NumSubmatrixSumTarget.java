package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/12/25.
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。

 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。

 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。

 *
 */
public class NumSubmatrixSumTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int[][] s = new int[n + 1][m + 1];
        //竖方向的前缀和
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                s[i][j] = s[i - 1][j] + matrix[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++){
            for (int j = i; j <= n; j++){
                Map<Integer, Integer> map = new HashMap();
                map.put(0, 1);
                //sum 水平方向的前缀和
                for (int k = 1, sum = 0; k <= m; k++){
                    sum += s[j][k] - s[i - 1][k];
                    res += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}
