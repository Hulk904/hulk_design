package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/28.
 *
 * 475. 供暖器
 *
 *冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。

 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。

 说明:

 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 所有供暖器都遵循你的半径标准，加热的半径也一样。

 */
public class FindRadius {

    public static void main(String[] args) {
        int[] data1 = {1,2,3,4};
        int[] data2 = {1,4};
        System.out.println(findRadius(data1, data2));
    }


    /**
     * 最近里求最大。。
     * @param houses
     * @param heaters
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int i = 0; i < houses.length; i++){
            /*
            先处理边界情况
             */
            if (houses[i] >= heaters[heaters.length - 1]){
                result = Math.max(result, houses[i] - heaters[heaters.length - 1]);
                continue;
            }
            if (houses[i] <= heaters[0]){
                result = Math.max(result, heaters[0] - houses[i]);
                continue;
            }
            int l = 0 , r = heaters.length - 1;
            while (l < r){
                int mid = (l + r) >> 1;
                if (heaters[mid] > houses[i]) r = mid;
                else l = mid + 1;
            }
            result = Math.max(result, Math.min(heaters[l] - houses[i],houses[i] - heaters[l - 1]));
        }
        return result;
    }

}
