package algorithms.other.array;

import java.util.*;

/**
 * Created by yangyuan on 2020/10/17.
 * 398. 随机数索引
 *
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。

 注意：
 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。

 */
public class Pick {

    Map<Integer, List<Integer>> map = new HashMap();

    Random random = new Random();

    public Pick(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) == null){
                map.put(nums[i], new ArrayList());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }

    //解法二  蓄水池
}
