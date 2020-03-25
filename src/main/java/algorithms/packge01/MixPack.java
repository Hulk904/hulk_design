package algorithms.packge01;

/**
 * Created by yangyuan on 2020/2/21.
 * 有的物品只可以取一次（01背包），有的物品可以取无限次（完全背包），有的物品可以取的次数有一个上限（多重背包
 */
public class MixPack {
    /*
    p[i]:每个物品的件数，0代表无穷个
for (int i = 1; i <= n; i++)
    if (p[i] == 0)
        for (int j = w[i]; j <= V; j++)
            f[j] = max(f[j], f[j - w[i]] + v[i]);
    else
    for (int k = 1; k <= p[i]; k++)
        for (int j = V; j >= w[i]; j--)
            f[j] = max(f[j], f[j - w[i]] + v[i]);
     */

    public static void main(String[] args) {

    }
}