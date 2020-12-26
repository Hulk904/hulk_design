package algorithms.toutiao;

/**
 * Created by yangyuan on 2020/2/17.
 * 518
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 示例 1:

 输入: amount = 5, coins = [1, 2, 5]
 输出: 4
 解释: 有四种方式可以凑成总金额:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 完全背包问题。。。
 */
public class CoinChange {

    public static void main(String[] args) {
        int [] coins = {1, 2, 5};
        System.out.println(change(5, coins));
        //test();
    }

    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        //这里需要手动初始化 选第一个商品时的情况
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void  test(){
        for (int i = 0; i <=6 && i >=3; i++){ //
            System.out.println(i);//这里不会被执行  for的执行逻辑啊啊啊。。。
        }
    }
}
