package algorithms.other.string;

/**
 * Created by yangyuan on 2020/9/12.
 * 306. 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。

 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。


 相当于判断一个没有符号的串，是不是斐波拉切数列

 */
public class IsAdditiveNumber {


    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    boolean dfs(String num, int length, int index, long sum, long pre, int k){
        if (index == length){
            return k > 2;
        }
        for (int i = index; i < length; i++){
            long cur = fetchNum(num, index, i);
            if (cur < 0) continue;
            if (k >= 2 && cur != sum){
                continue;
            }
            if (dfs(num, length, i + 1, pre + cur, cur, k + 1)){
                return true;
            }
        }
        return false;
    }

    long fetchNum(String num, int start, int end){
        if (start < end  && num.charAt(start) == '0') return -1;
        long res = 0;
        for (int i = start; i <= end; i++){
            res = res*10 + (num.charAt(i) - '0');
        }
        return res;
    }
}
