package algorithms.other;

/**
 * Created by yangyuan on 2020/12/20.
 *
 * 633. 平方数之和
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        JudgeSquareSum j = new JudgeSquareSum();
        System.out.println(j.judgeSquareSum(2147483646));
    }

    //
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i*i <= c; i++){//i 不为long 会陷入死循环
            int j = (int)(c - i*i);
            int temp = (int)Math.sqrt(j);
            if (temp*temp == j) {
                return true;
            }
        }
        return false;
    }
}
