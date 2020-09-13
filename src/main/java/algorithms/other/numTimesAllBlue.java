package algorithms.other;

/**
 * Created by yangyuan on 2020/4/4.
 * 房间中有 n 枚灯泡，编号从 1 到 n，自左向右排成一排。最初，所有的灯都是关着的。

 在 k  时刻（ k 的取值范围是 0 到 n - 1），我们打开 light[k] 这个灯。

 灯的颜色要想 变成蓝色 就必须同时满足下面两个条件：

 灯处于打开状态。
 排在它之前（左侧）的所有灯也都处于打开状态。
 请返回能够让 所有开着的 灯都 变成蓝色 的时刻 数目 。

 */
public class NumTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        //当前最大值 等于扫描过的数 个数  说明之前的灯都连续亮着了，那么这个时刻灯都是蓝色的
        int curMax = 0;
        int res = 0;
        for (int i = 0; i < light.length; i++){
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1){
                res++;
            }
        }
        return res;
    }
}
