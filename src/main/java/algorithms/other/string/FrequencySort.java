package algorithms.other.string;

import java.util.*;

/**
 * Created by yangyuan on 2020/10/31.
 * 451. 根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class FrequencySort {

    public static void main(String[] args) {
        FrequencySort f = new FrequencySort();
        f.frequencySort("raaeaedere");
    }
    //todo ???
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        /*
           1  这里不用使用TreeSet来排序，因为 重复元素的问题。
           2  对于queue的遍历。 不能直接 迭代遍历 因为queue里面的元素本身不是全部有序的。它只是大顶堆或者小顶堆。
               所以需要边删除边遍历，这样的才是有序的。。
         */
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> cur = queue.poll();
            int times = cur.getValue();
            while (times -- > 0){
                sb.append(cur.getKey());
            }
        }
        return sb.toString();
    }
}
