package algorithms.other;

/**
 * Created by yangyuan on 2020/4/14.
 *
 * 面试题 01.05. 一次编辑
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑
 */
public class OneEditAway {

    /**
     * 动态规划--编辑距离  相对较慢
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++){
            dp[i][0] = i;
        }
        for (int i = 0; i <= second.length(); i++){
            dp[0][i] = i;
        }
        for (int i = 1; i <= first.length(); i++){
            for (int j = 1; j <= second.length(); j++){
                int a = dp[i][j - 1] + 1;
                int b = dp[i - 1][j] + 1;
                int c = dp[i - 1][j - 1];
                if (first.charAt(i - 1) != second.charAt(j - 1)){
                    c++;
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[first.length()][second.length()] <= 1;
    }

    //字符串比较 相对上面快些
    public boolean oneEditAway2(String first, String second) {
        if(second.length() > first.length()){
            String temp = first;
            first = second;
            second = temp;
        }
        if (first.length() - second.length() > 1) return false;
        for (int i = 0; i < second.length(); i++){
            if (first.charAt(i) != second.charAt(i)){//一次不相同了
                return first.substring(i + 1).equals(first.length() == second.length()//如果长度相同统一从下个元素开始，如果不同短的从当前元素开始
                        ? second.substring(i + 1) : second.substring(i));
            }
        }
        return true;
    }
}
