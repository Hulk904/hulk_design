package algorithms.other.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/4.
 * 233. 数字 1 的个数
 *给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * NumCount 的简单情况。
 *
 */
public class CountDigitOne {

    public int countDigitOne(int n) {
        List<Integer> nums = new ArrayList();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {

            //1不在最高位时可能的情况  xxx1yyy
            if (i < nums.size() - 1) {
                count += getNum(nums, nums.size() - 1, i + 1) * Math.pow(10, i);
            }
            //abcdyyy
            //d大于1时，yyy 可以 0～999 1000种情况
            if (nums.get(i) > 1) {
                count += Math.pow(10, i);
            } else if (nums.get(i) == 1) {//d == 1时 ，0～ efg。 一共efg + 1种可能。  abc d efg
                count += getNum(nums, i - 1, 0) + 1;
            }
        }
        return count;
    }

    /**
     * r ～ l  构成的新数字
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int getNum(List<Integer> nums, int l, int r) {
        int res = 0;
        for (int i = l; i >= r; i--) {
            res = res * 10 + nums.get(i);
        }
        return res;
    }

    /**
     * 按下面连接统一理解
     * https://note.youdao.com/web/#/file/recent/note/WEB8fd3114048c80eae4a3c79155f3e65c2/
     * @param n
     * @return
     */
    public int countDigitOne2(int n) {
        List<Integer> num = new ArrayList<>();
        int m = n;
        while (n > 0){
            num.add(n%10);
            n=n/10;
        }
        Collections.reverse(num);
        int res = 0;
        for (int i = 0; i < num.size(); i++){
            int left = 0, right = 0, pow = 1;
            for (int j = 0; j < i; j++){
                left = left*10 + num.get(j);
            }
            for (int j = i + 1; j < num.size(); j++){
                pow = pow*10;
                right = right*10 + num.get(j);
            }
            if (num.get(i) == 0){
                res += (left*pow);
            } else if(num.get(i) == 1){
                res += (left*pow + right + 1);
            } else  {
                res += (left + 1)*pow;
            }
        }
        return res;
    }
}
