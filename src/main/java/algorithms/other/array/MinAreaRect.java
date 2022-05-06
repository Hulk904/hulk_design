package algorithms.other.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/6/26.
 * 939. 最小面积矩形
 * 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。

 如果没有任何矩形，就返回 0。
 */
public class MinAreaRect {

    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet();
        for (int[] i:points){
            set.add(get(i[0], i[1]));
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                int[] p = points[i], q = points[j];
                if (p[0] != q[0] && p[1] != q[1] && set.contains(get(p[0], q[1])) && set.contains(get(q[0], p[1]))){
                    res = Math.min(res, Math.abs(p[0] - q[0])*Math.abs(p[1] - q[1]));
                }
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        return res;
    }
    int get(int x, int y){
        return x*50000 + y;
    }
}
