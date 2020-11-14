package algorithms.other.erfen;

/**
 * Created by yangyuan on 2020/9/26.
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：

 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。
 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

 */
public class GuessNumber {

    public int guessNumber(int n) {
        int l = 1, r = n;
        while ( l < r){
            int mid = (int)((long)l + r + 1 >> 1);
            if (guess(mid) >= 0) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    int guess(int a){
        return 1;
    }
}
