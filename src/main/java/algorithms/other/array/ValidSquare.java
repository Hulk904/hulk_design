package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/12/6.
 * 593. 有效的正方形
 *
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。

 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 */
public class ValidSquare {

    //通过四个点之间的距离判断是不是正方形。
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] distance = new int[]{distance(p1, p2), distance(p1, p3), distance(p1, p4), distance(p2, p3), distance(p2, p4), distance(p3, p4)};
        Arrays.sort(distance);
        if (distance[0] == 0) return false;//特殊判断 ，点重合的情况
        //最短的四个距离相等， 最长的两个距离相等
        return distance[0] == distance[1] && distance[0] == distance[2] && distance[0] == distance[3] && distance[4] == distance[5];
    }

    int distance(int[] p1, int [] p2){
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx*dx + dy*dy;
    }
}
