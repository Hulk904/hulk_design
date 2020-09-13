package algorithms.other;

/**
 * Created by yangyuan on 2020/7/4.
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 *
 */
public class MySqrt {

    public int mySqrt(int x) {
        long l = 1, r = x;
        while (l < r){
            long mid = (l + r + 1) >> 1;
            if (mid*mid <= x) l = mid ; //不能写成 mid*mid >= x r = mid . 因为去掉小数后的，向下取整
            else r = mid - 1;
        }
        return (int)l;
    }
}
