package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/27.
 * 264. 丑数 II
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。

 示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

 */
public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(12));
    }

    static int nthUglyNumber2(int n){
        int a = 0, b = 0, c = 0;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(result[a]*2, result[b]*3), result[c]*5);
            result[i] = min;
            if (min == result[a]*2) a++;
            if (min == result[b]*3) b++;
            if (min == result[c]*5) c++;
        }
        return result[n - 1];
    }

    public static int nthUglyNumber(int n) {
        List<Integer> uglyNumber = new ArrayList<>(n);
        uglyNumber.add(1);
        int i = 0, j = 0, k= 0;
        while (--n > 0){
            int newNum = Math.min(Math.min(uglyNumber.get(i)*2, uglyNumber.get(j)*3),
                    uglyNumber.get(k)*5);
            uglyNumber.add(newNum);
            if (newNum == uglyNumber.get(i)*2) i++;
            if (newNum == uglyNumber.get(j)*3) j++;
            if (newNum == uglyNumber.get(k)*5) k++;
        }
        return uglyNumber.get(uglyNumber.size() - 1);
    }
}
