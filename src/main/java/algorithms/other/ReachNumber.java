package algorithms.other;

/**
 * Created by yangyuan on 2021/3/28.
 * 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。

 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。

 返回到达终点需要的最小移动次数。

 */
public class ReachNumber {
    // 满足两个条件  sum >= target,    sum 跟 target的奇偶性相同。
    public int reachNumber(int target) {
        target = Math.abs(target);
        int n = 0, sum = 0;
        while (sum < target || (sum - target)%2 != 0){
            n++;
            sum += n;
        }
        return n;
    }
}
