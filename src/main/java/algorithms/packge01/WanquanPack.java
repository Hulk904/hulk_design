package algorithms.packge01;

/**
 * Created by yangyuan on 2020/2/21.
 * 完全背包问题
 * 有NNN种物品和一个容量为VVV的背包，每种物品都有无限件可用。第iii种物品的费用是w[i]w[i]w[i]，价值是v[i]v[i]v[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 ————————————————
 版权声明：本文为CSDN博主「良月澪二」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/yandaoqiusheng/article/details/84782655
 */
public class WanquanPack {

    //CoinChange  零钱兑换就是个完全背包问题
    /* 状态转移方程
    与01背包问题的区别就是内层循环是递增的。。
    for (int i = 1; i <= n; i++)
     for (int j = w[i]; j <= V; j++)
        f[j] = max(f[j], f[j - w[i]] + v[i]);
     */

    public static void main(String[] args) {

    }
}
