package algorithms.other.string;

import java.util.*;

/**
 * Created by yangyuan on 2021/3/13.
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。

 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class TopKFrequent {


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (String s:words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        q.addAll(map.entrySet());
        List<String> res = new ArrayList();
        while (k-- > 0){
            res.add(q.poll().getKey());
        }
        return res;
    }
}
