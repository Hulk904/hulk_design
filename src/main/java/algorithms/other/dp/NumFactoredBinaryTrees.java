package algorithms.other.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/10.
 * 823. 带因子的二叉树
 *
 * 给出一个含有不重复整数元素的数组，每个整数均大于 1。

 我们用这些整数来构建二叉树，每个整数可以使用任意次数。

 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。

 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。

 */
public class NumFactoredBinaryTrees {

    //dp
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        int[] dp = new int[n];
        int res = 0, MOD = (int)1e9 + 7;
        for (int i = 0; i < n; i++){
            dp[i] = 1;//没有子节点
            //枚举所有的分解方式
            for (int j = 0; j < i; j++){
                if (arr[i]%arr[j] == 0){
                    int d = arr[i]/arr[j];
                    if (map.get(d) != null){
                        int k = map.get(d);
                        dp[i] = (int)((dp[i] + (long)dp[j]*dp[k])%MOD);
                    }
                }
            }
            res = (res + dp[i])%MOD;
        }
        return res;
    }
}
