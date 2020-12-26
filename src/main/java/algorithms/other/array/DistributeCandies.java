package algorithms.other.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2020/11/29.
 *
 * 575. 分糖果
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。



 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet();
        for(int i:candies) set.add(i);
        return Math.min(candies.length/2, set.size());
    }
}
