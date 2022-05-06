package algorithms.packge01;

/**
 * Created by yangyuan on 2020/2/21.
 * 完全背包问题
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的费用是w[i]，价值是v[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 ————————————————
 每件物品无限个

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
        //完全背包朴素做法
//        int n = 10,m=10;
//        int[][] f = new int[n][n];
//        for(int i = 1; i <= n ;i++){
//            for(int j = 0; i <= m; j++){
//                for (int k = 0; i * v[i] <= j; k++){
//                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]*k] + w[i] * k);
//                }
//            }
//        }


        //由
        //f[i,j] = Max(f[i - 1, j], f[i- 1, j -v] + w, f[i - 1, j -2v] + 2w, f[i - 1, j - 3v] + 3w ...)
        //f[j, j - v]=max(          f[i- 1, j - v],    f[i - 1, j- 2v] + w   f[i - 1, j - 3v] + 2w, ...)

        //推倒出 (状态转移方程)
        // f[i, j] = max(f[i - 1, j], f[i, j - v] + w)      //由i层转移过来
        //0，1 背包问题的状态转移方程
        // f[i, j] = max(f[i - 1, j], f[i - 1, j - v] + w) //由i- 1层转移过来


        //去掉一维后
//        for(int i = 1; i <= n ;i++){
//            for(int j = 0; j <= m; j++){
//                f[i][j] = f[i - 1][j];
//                if (j >= v[i]){
//                    f[i][j] = Math.max(f[i][j], f[i][j - v[i] + w[i]]);
//                }
//
//            }
//        }
        //跟01 一样，去掉一维后  终极写法
//        for(int i = 1; i <= n ;i++){
//            for(int j = v[i]; j <= m; j++){
//                f[j] = max(f[j], f[j - v[i] + w[i]]);
//
//            }
//        }


    }
}
