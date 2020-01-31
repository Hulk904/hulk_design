package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/15.
 *
 * 前 K 个高频元素
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] data = {1,1,1,2,2,3};
        System.out.println(JSON.toJSONString(topKFrequent(data, 2)));
    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> statics = new HashMap<>();
        for (int a:nums){
            statics.put(a, statics.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> entries =
                new PriorityQueue((o1, o2) -> ((Map.Entry<Integer,Integer>)o1).getValue() - ((Map.Entry<Integer,Integer>)o2).getValue());
        for (Map.Entry<Integer, Integer> entry1:statics.entrySet()){
            entries.add(entry1);
            if (entries.size() > k){
                entries.poll();
            }
        }
        List<Integer> result = new ArrayList<>(k);
        while (entries.size() > 0){
            result.add(entries.poll().getKey());
        }
        return result;
    }

}
