package algorithms.other.dp;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/3.
 * 338. 计数问题  acwing
 * 给定两个整数 a 和 b，求 a 和 b 之间的所有数字中0~9的出现次数。
 例如，a=1024，b=1032，则 a 和 b 之间共有9个数如下：
 1024 1025 1026 1027 1028 1029 1030 1031 1032
 其中‘0’出现10次，‘1’出现10次，‘2’出现7次，‘3’出现3次等等…
 */
public class NumCount {

    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(numCount(44 ,497)));
    }

    private static List<Integer> numCount(int a, int b){
        if (b > a){
            int temp = b;
            b = a;
            a = temp;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= 9; i++){
            res.add(count(a, i) - count(b - 1, i));
        }
        return res;
    }

    /**
     * 从 1 到 n之间 x 出现的次数
     * @param n
     * @param x
     * @return
     */
    private static  int count(int n, int x){
        if ( n == 0) return 0;
        List<Integer> num = new ArrayList<>();
        while (n > 0){
            num.add(n%10);
            n/=10;
        }
        n = num.size();
        int res = 0;
        for ( int i = n - 1 - (x==0 ? 1 : 0); i >= 0; i--){
            if (i < n - 1){
                res += get(num, n - 1, i + 1)*(int)Math.pow(10, i);
                if (x == 0) {//如果是0 不能以前缀0开始了
                    res -= Math.pow(10, i);
                }
            }
            if (num.get(i) == x){
                res += get(num, i - 1, 0) + 1;
            } else if (num.get(i) > x ){
                res += Math.pow(10, i);
            }
        }
        return res;
    }

    /**
     * 前面的位组成的数字是多少
     * @param num
     * @param l
     * @param r
     * @return
     */
    static int get (List<Integer> num, int l, int r){
        int res = 0;
        for (int i = l ; i >= r; i--){
            res = res*10 + num.get(i);
        }
        return res;
    }
}
