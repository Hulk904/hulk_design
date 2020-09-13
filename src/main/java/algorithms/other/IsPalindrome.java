package algorithms.other;

/**
 * Created by yangyuan on 2020/4/20.
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。

 */
public class IsPalindrome {

    /**
     * 直接用一个中间变量来实现，没必要弄个数组啥的。
     * 当x是偶数个数字时 则 x和a一样
     * 当x是奇数个数字时 a 会比x多最后一个数字
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x%10 == 0)) return false;
        int a = 0;
        while (x > a){
            a = a*10 + x%10;
            x = x/10;
        }
        return x == a || x == a/10;
    }
}
