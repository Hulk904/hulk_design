package algorithms.other.math;

/**
 * Created by yangyuan on 2021/4/27.
 * 793. 阶乘函数后 K 个零
 *
 *  f(x) 是 x! 末尾是 0 的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 ）

 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。给定 K，找出多少个非负整数 x ，能满足 f(x) = K 。

 */
public class PreimageSizeFZF {

    public int preimageSizeFZF(int K) {
        return (int)(cal(K) - cal(K - 1));
    }
    //二分
    long cal(int k){
        long l = -1, r = (long)1e18;
        while (l < r){
            long mid = l + r + 1 >> 1;
            if (f(mid) <= k) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    //计算 x阶乘后有几个0
    long f (long x){
        long res = 0;
        while (x > 0) {
            res += x/5;
            x/=5;
        }
        return res;
    }
}
