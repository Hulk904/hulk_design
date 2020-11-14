package algorithms.other.math;

/**
 * Created by yangyuan on 2020/10/5.
 * 390. 消除游戏
 * 给定一个从1 到 n 排序的整数列表。
 首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
 第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
 我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 返回长度为 n 的列表中，最后剩下的数字。

 */
public class LastRemaining {

    //  约瑟夫问题  通常dp可以解决
    //f(n)表示正着计算，g(n)表示反着计算
    // f(n) = 2g(n/2)     ;       f(n) + g(n) = n + 1 即  g(n) = n + 1 - f(n)  带入第一个式子中
    //可以推出  f(n) = 2 (n/2 + 1 - f(n/2))
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2*(n/2 + 1 - lastRemaining(n/2));
    }
}
