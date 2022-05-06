package algorithms.other.dp;

/**
 * Created by yangyuan on 2020/12/12.
 * 600. 不含连续1的非负整数
 *
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数
 */
public class FindIntegers {

    //数位dp 经典 （通常是  小于等于 某个数 满足某个条件数的问题）
    //1、预处理
    //2、按位做 （分类讨论）
    public int findIntegers(int num) {
        String t = Integer.toBinaryString(num);
        int[][] dp = new int[t.length() + 1][2];//最高位0 一共i位， 和最高位为1 一共i位  合法总数
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i <= t.length(); i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        int res = 0;
        for (int i = 1, last = 0; i <= t.length(); i++){
            int x = t.charAt(i - 1) - '0';
            if (x > 0){
                res += dp[t.length() - i + 1][0];//注意取值
                if (last > 0) return res;//出现了两个连续的1 ，就没有必要再继续做了
            }
            last = x;
        }
        return res + 1;//加上n本身
    }

    public static void main(String[] args) {
        FindIntegers findIntegers = new FindIntegers();
        System.out.println(findIntegers.findIntegers(7));
    }
}
