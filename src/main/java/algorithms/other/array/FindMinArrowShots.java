package algorithms.other.array;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/10/31.
 * 452. 用最少数量的箭引爆气球
 *
 * 为什么这个用例不能通过？
 * [[-2147483646,-2147483645],[2147483646,2147483647]]
 */
public class FindMinArrowShots {


    public static void main(String[] args) {
        FindMinArrowShots f = new FindMinArrowShots();
        int [][] a = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        f.findMinArrowShots(a);
    }
    //所有区间右端点排序
    //从左往右遍历
    //后序区间是否包含 右端点， 不包含则++
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (o1, o2) -> {
            long a = 0l + o1[1] - o2[1];//可能int溢出
            if (a > Integer.MAX_VALUE) return 1;
            return (int)a;
        } );
        int res = 1;
        int r = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (points[i][0] > r){
                res++;
                r = points[i][1];
            }
        }
        return res;
    }
}
