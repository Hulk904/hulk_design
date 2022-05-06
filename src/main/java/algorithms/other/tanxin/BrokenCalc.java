package algorithms.other.tanxin;

/**
 * Created by yangyuan on 2021/11/13.
 *
 * 991. 坏了的计算器
 *
 * 在显示着数字的坏计算器上，我们可以执行以下两种操作：

 双倍（Double）：将显示屏上的数字乘 2；
 递减（Decrement）：将显示屏上的数字减 1 。
 最初，计算器显示数字 X。

 返回显示数字 Y 所需的最小操作数。

 */
public class BrokenCalc {

    public int brokenCalc(int x, int y) {
        int res = 0;
        //逆向 由y变为x， 有两种操作 y + 1,或者 y/2
        //当y是偶数时有两种选择为什么选择 y/2  因为由  y变为 （y+k）/2 , y/2 然后加上k/2小于k
        while (y > x){
            if (y%2 > 0) y++;
            else y/=2;
            res++;
        }
        return res + x - y;//当y小于x时 只能每次加1 了
    }
}
