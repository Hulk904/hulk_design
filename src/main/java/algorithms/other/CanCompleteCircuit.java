package algorithms.other;

/**
 * Created by yangyuan on 2020/7/26.
 * 134. 加油站
 *
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

 说明: 

 如果题目有解，该答案即为唯一答案。
 输入数组均为非空数组，且长度相同。
 输入数组中的元素均为非负数。
 https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < gas.length; i++){
            spare += gas[i] - cost[i];
            if (spare < min){
                res = i;
                min = spare;
            }
        }
        return spare < 0 ? -1 : (res + 1)%gas.length;
    }
}
