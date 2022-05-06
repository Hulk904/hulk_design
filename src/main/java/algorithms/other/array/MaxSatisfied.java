package algorithms.other.array;

/**
 * Created by yangyuan on 2021/12/19.
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，
 * 所有这些顾客都会在那一分钟结束后离开。

 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 请你返回这一天营业下来，最多有多少客户能够感到满意。

 */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //答案分为两部分。原本满意和新增满意，原本满意是个定植，
        //需要做的就是找到新增满意的最大值，双指针和前缀和都行
        int res = 0;
        int n = customers.length;
        //新增部分 双指针
        for (int i = 0, s = 0; i< n; i++){
            s += grumpy[i]*customers[i];
            if (i>= minutes) s-= grumpy[i - minutes] * customers[i - minutes];
            res = Math.max(res, s);
        }
        //固定部分
        for (int i = 0; i < n; i++){
            if (grumpy[i] == 0) res += customers[i];
        }
        return res;
    }
}
