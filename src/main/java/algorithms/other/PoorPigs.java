package algorithms.other;

/**
 * Created by yangyuan on 2020/3/1.
 *458. 可怜的小猪
 * 有 1000 只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在 15 分钟内死去。

 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？

 回答这个问题，并为下列的进阶问题编写一个通用算法。

 */
public class PoorPigs {

    public static void main(String[] args) {
        System.out.println(poorPigs(1000, 15, 60));
    }
//https://leetcode-cn.com/problems/poor-pigs/solution/hua-jie-suan-fa-458-ke-lian-de-xiao-zhu-by-guanpen/
    //可以看上面的图解。 比如 2头猪为什么可以验证 25 桶水？  可以五桶混合在一起喝的。。。
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int b = minutesToTest/minutesToDie + 1;
        int k = 0, n = 1;
        while (n < buckets){
            k++;
            n*=b;
        }
        return k;
    }
}
