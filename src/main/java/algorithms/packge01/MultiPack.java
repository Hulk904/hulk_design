package algorithms.packge01;

/**
 * Created by yangyuan on 2020/2/21.
 * 多重背包
 * 每个物品 最多s[i]个
 *
 * 有N种物品和一个容量为V的背包。第i种物品最多有p[i]件可用，每件费用是w[i]，价值是v[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */
public class MultiPack {

    // 多重背包 朴素做法  跟  完全差不多
//        int n = 10,m=10;
//        int[][] f = new int[n][n];
//        for(int i = 1; i <= n ;i++){
//            for(int j = 0; j <= m; j++){
//                for (int k = 0; k <= s[i] && k*v[i] <= j; k++){
//                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]*k] + w[i] * k);
//                }
//            }
//        }

    // 二进制优化方式
    //比如 s[i] = 1023  是不是都需要从0 到 1023 都试一遍呢？
    //可以把 1023 分为 1， 2， 4， 8 ，16  ... 512  个包， 这些数可以 尝试  为1~1024的所有情况

    //c++版本
//    int cnt = 0;
//    for (int i = 1; i <= n; i++){
//        int a, b , s;
//        cin >>a >>b >>s;
//        int k = 1;
//        while (k <= s){
//            cnt++;
//            v[cnt] = a *k;
//            w[cnt] = b*k;
//            s -= k;
//            k *= 2;
//        }
//        if (s > 0){
//            cnt++;
//            v[cnt] = a*s;
//            w[cnt] = b*s;
//        }
//
//    }
//    n = cnt;
//    for (int i = 1; i < = n; i ++){
//        for (int j = m; j >= v[i]; j--){
//            f[j] = max(f[j], f[j - v[i]] + w[i]);
//        }
//    }
//    return f[m];

}
