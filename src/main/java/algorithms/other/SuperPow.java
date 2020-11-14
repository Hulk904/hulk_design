package algorithms.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/9/26.
 * 372. 超级次方
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 */
public class SuperPow {

    int p = 1337;
    //快速幂
    int qmi(int a, int b){
        a %= p;
        int res = 1;
        while (b > 0){
            if ((b & 1) == 1) res = res * a % p;
            a = a*a % p;
            b >>= 1;
        }
        return res;
    }

    int superPow(int a, int[] b){
        if (b.length == 0) return 1;
        List<Integer> list = new ArrayList<>();
        for (int i:b ){
            list.add(i);
        }
        return pow(a, list);
    }

    int pow(int a, List<Integer> b){
        if (b.size() == 0)return 1;
        int k = b.get(b.size() - 1);
        b.remove(b.size() - 1);
        return qmi(pow(a, b), 10) * qmi(a, k) % p;
    }

}
