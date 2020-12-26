package algorithms.other;

/**
 * Created by yangyuan on 2020/11/15.
 * 507. 完美数
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。

 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false

 */
public class CheckPerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        int max = (int)Math.sqrt(num);
        for (int i = 1; i <= max; i++){//不用从 num/2开始考虑， 因为是对称的
            if (num%i == 0){
                if (i < num) sum += i;//加上除数
                if (i != num/i && num/i < num) sum+=num/i;//加上商 （排除相等情况）
            }
        }
        return sum == num;
    }
}
