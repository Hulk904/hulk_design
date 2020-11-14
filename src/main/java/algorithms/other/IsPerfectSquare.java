package algorithms.other;

/**
 * Created by yangyuan on 2020/9/26.
 *
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

 说明：不要使用任何内置的库函数，如  sqrt。

 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r){
            int mid = (l + r + 1) >> 1;
            if (mid <= num/mid) l = mid;
            else r = mid - 1;
        }
        return l*l == num;
    }
}
