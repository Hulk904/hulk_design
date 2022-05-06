package algorithms.other;

/**
 * Created by yangyuan on 2020/3/1.
 * 829. 连续整数求和
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 数学问题
 * 如果 n = a + (a + 1) + .... + (a + b - 1)  b个数之和
 * 则 a = (2n/b - (b-1))/2
 *
 * 上面公式所有除法都要整除
 * a 大于0
 * 结论：
 * 1、b是2n的约数
 * 2、2n > b(b-1)
 */
public class ConsecutiveNumbersSum {
    //a开始 ，项数是b的和
    //2*a = 2N/b  - (b - 1)
    //然后判断上面的情况  比如 2N/b 可以整除，  右边值为偶数
    //枚举b
    public int consecutiveNumbersSum(int N) {
        int result = 0;
        for (int b = 1; b*b <= 2*N; b++){
            if (2*N%b == 0 && ((2*N/b - (b-1))&1)==0){
                result++;
            }
        }
        return result;
    }
}
