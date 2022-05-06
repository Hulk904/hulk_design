package algorithms.packge01;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/20.
 * 01背包问题
 * <p>
 * 有n件物品，每件物品的重量为w[i]，价值为c[i]。现有一个容量为V的背包，问如何选取物品放入背包，使得背包内物品的总价值最大。其中
 * 每种物品都只有一件  [不一定要装满 ]
 *
 * https://www.bilibili.com/video/av36136952?from=search&seid=9369792597036016364
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5, 9};
        int[] value = {3, 4, 5, 8, 10};
        System.out.println(maxValue(weight, value, 20));
    }

    /**
     * 如果不塞个元素进商品里面，处理逻辑还是不是很好看的 --- 对  0 行数据的特殊处理
     * 空间复杂度 M*N
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    private static int maxValue(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j - weight[i - 1] >= 0) {
                    //前i个物品，容量j
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);// 选和不选 中选择 最大值
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][capacity];
    }

    /**
     *  优化， 使用 N 空间复杂度
     *  计算dp[i]时只依赖dp[i-1]所以可以用滚动数组来替代
     *  由于dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
     *  如果还是按从小到达遍历。在计算j时 j- weight[i]
     *  还没有被计算出来呢。
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    private static int maxValue2(int[] weight, int[] value, int capacity){
        int[] dp = new int[capacity + 1];
        //不要求把书包装满的，没必要进行特殊的初始化。
        //在第一次遍历的时候从0开始  （有的好多例子都是从1开始的，那里的1表示第一个商品 ，一样的事）
//        for (int j = 0; j <= capacity; j++) {
//            if (weight[0] <= j) {
//                dp[j] = value[0];
//            } else {
//                dp[j] = 0;
//            }
//        }
        for (int i = 0; i < weight.length; i++){//没有上面的初始化这里从0开始。。
            for (int j = capacity; j >= weight[i]; j--) {//注意这里逆序遍历
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(JSON.toJSONString(dp));
        }
        return dp[capacity];
    }


}
