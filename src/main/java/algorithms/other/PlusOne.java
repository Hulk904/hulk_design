package algorithms.other;

/**
 * Created by yangyuan on 2020/4/19.
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 */
public class PlusOne {


    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >=0; i--){
            int sum = digits[i] + carry;
            if (sum >= 10){
                digits[i] = sum%10;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
                break;
            }
        }
        if (carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++){
                res[i + 1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }

    /**
     * 精选答案
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];//如果还有进位那说明前面一定全是9
        digits[0] = 1;
        return digits;
    }



}
