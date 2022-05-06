package algorithms.other.dp;

/**
 * Created by yangyuan on 2021/6/12.
 * 902. 最大为 N 的数字组合
 *
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）

 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。

 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。

 */
public class AtMostNGivenDigitSet {
    int power(int a, int b){
        int res = 1;
        while(b-- > 0) res*= a;
        return res;
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = new StringBuilder(n + "").reverse().toString();
        int res = 0;
        for (int i = 1; i < num.length(); i++) res+= power(digits.length, i);
        boolean flag = true;
        for(int i = num.length() - 1; i >= 0; i--){
            int x =num.charAt(i) - '0', t = power(digits.length, i);
            int j = 0;
            for (j = 0; j < digits.length; j++){
                if (digits[j].charAt(0) - '0' < x){
                    res += t;
                } else {
                    break;
                }
            }
            if (j < digits.length && digits[j].charAt(0) - '0' == x) continue;
            flag = false;
            break;
        }
        if (flag) res++;
        return res;
    }
}
