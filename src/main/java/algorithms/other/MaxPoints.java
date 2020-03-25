package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/2/25.
 * 149. 直线上最多的点数
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 */
public class MaxPoints {

    public static void main(String[] args) {
        int[][] data = {{0,0}, {1,65536}, {65536,0}};
        System.out.println(new MaxPoints().maxPoints(data));
    }

    public int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++){
            //最开始想只定义一个vertical应该可以解决问题 因为重复斜率也是无穷大呢
            //其实不行 因为vertial跟正常是互斥的，而重复和正常是可以累加的
            int vertical = 1;
            int duplicate = 0;
            int normal = 0;
            for (int j = i + 1; j < points.length; j++){
                if (points[i][1] == points[j][1]){//vertical
                    if (points[i][0] == points[j][0]){
                        duplicate++;
                    } else {
                        vertical++;
                    }
                }
            }
            for (int j = i + 1; j < points.length; j++){
                if (points[i][1] != points[j][1]){
                    double xie = xielv(points, i, j);
                    if (map.containsKey(xie)){
                        normal = Math.max(normal, map.get(xie) + 1);
                        map.put(xie, map.get(xie) + 1);
                    } else {
                        map.put(xie ,2);
                        normal = Math.max(normal, 2);
                    }
                }
            }

            result = Math.max(result,Math.max(normal, vertical) + duplicate);
            map.clear();
        }
        return result;
    }

    /**
     * 这里其实是斜率的倒数
     * 如果是斜率将会有精度问题， 比如 [[0,0],[94911151,94911150],[94911152,94911151]] 这样的点
     * 第一个点和第二个点及第一个点和第三个点 计算出来的斜率一样。如果倒过来 double就可以区分了
     * @param points
     * @param a
     * @param b
     * @return
     */
    public Double xielv(int[][] points, int a, int b){
        return  (points[a][0] + 0.0 -points[b][0])/(points[a][1] + 0.0 - points[b][1]) + 0.0;
    }


}
