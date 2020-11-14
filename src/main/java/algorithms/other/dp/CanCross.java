package algorithms.other.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/10/17.
 * 403. 青蛙过河
 *
 * 一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。
 * 青蛙可以跳上石头，但是不可以跳入水中。

 给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 
 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。

 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

 */
public class CanCross {

    int[] stones;
    Map<Integer, Integer> map;//记忆化搜索
    int[][] f;

    public boolean canCross(int[] stones) {
        //f(i,j) 表示从第i个石头开始跳跃j的距离是否合法
        this.stones = stones;
        this.map = new HashMap<>();
        int  n = stones.length;
        for (int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        f = new int[n + 1][n + 1];
        for (int i = 0; i <  n; i++){
            Arrays.fill(f[i], -1);
        }
        f[0][1] = 1;
        for (int i = 0; i < n; i++){
            if (dp(n - 1, i) > 0)
                return true;
        }
        return false;
    }
    int dp (int i, int j){
        if (f[i][j] != - 1) return f[i][j];
        f[i][j] = 0;
        for (int k = Math.max(1, j - 1); k <= j + 1; k++){
            if (map.get(stones[i] - k) != null){
                int p = map.get(stones[i] - k);
                if (dp(p, k) > 0){
                    f[i][j] = 1;
                    break;
                }
            }
        }
        return f[i][j];
    }
}
