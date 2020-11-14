package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/10/25.
 * 447. 回旋镖的数量
 *
 *
 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Integer> cnt = new HashMap();
            for (int j = 0; j < points.length; j++){
                if (i != j){
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int dist = dx*dx + dy*dy;
                    cnt.put(dist, cnt.getOrDefault(dist, 0) + 1);
                }
            }
            for (Map.Entry<Integer,Integer> en:cnt.entrySet()){
                res += en.getValue()*(en.getValue() - 1);
            }
        }
        return res;
    }
}
