package algorithms.other.math;

/**
 * Created by yangyuan on 2020/6/27.
 * 60. 第k个排列
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。

 */
public class GetPermutation {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] st = new boolean[10];
        //一位一位的确定
        for (int i = 0; i < n; i++){
            int fact = 1;
            //求阶乘 。 比如有四个数 1234 第一个数确定了那么后面有 3！个数
            for (int j = 1; j <= n -i -1; j++) fact *=j;

            for (int j = 1; j <= n; j++){
                if (!st[j]){
                    if (fact < k) k -= fact;
                    else {
                        sb.append(j);
                        st[j] = true;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

}
