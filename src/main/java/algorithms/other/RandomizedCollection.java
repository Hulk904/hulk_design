package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2020/10/2.
 *
 * 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

 注意: 允许出现重复元素。

 insert(val)：向集合中插入元素 val。
 remove(val)：当 val 存在时，从集合中移除一个 val。
 getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

 */
public class RandomizedCollection {

    Map<Integer, Set<Integer>> map = new HashMap<>();

    List<Integer> list = new ArrayList<>();

    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        if (map.get(val) != null && map.get(val).size() > 0){
            res = false;
        } else {
            map.put(val, new HashSet<>());
        }
        list.add(val);
        map.get(val).add(list.size() - 1);
        return  res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.get(val) != null && map.get(val).size() > 0){
            //exist
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            int lastEle = list.get(list.size() - 1);
            list.set(index, lastEle);
            //为什么下面两步不能交换位置  如果删除的元素是数组最后一个元素时，交换了将会出现问题 （即当 index  == list.size() - 1）
            map.get(lastEle).add(index);
            map.get(lastEle).remove(list.size() - 1);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
