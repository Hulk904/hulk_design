package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/15.
 * 347
 * 前 K 个高频元素
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] data = {1,1,1,2,2,3};
        System.out.println(JSON.toJSONString(topKFrequentTimes2(data, 2)));
    }


    /**
     * 基于 计数 排序
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequentTimes2(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] s = new int[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){//key  数字， value 频率
            s[entry.getValue()]++;
        }
        int i = s.length - 1;//频率由低到高
        int total = 0;
        for (; i >= 0 & total < k;){
            total += s[i--];
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue() > i){
                result.add(entry.getKey());
            }
        }
        return result;
    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> statics = new HashMap<>();
        for (int a:nums){
            statics.put(a, statics.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> entries =
                new PriorityQueue((o1, o2) -> ((Map.Entry<Integer,Integer>)o1).getValue() - ((Map.Entry<Integer,Integer>)o2).getValue());
        for (Map.Entry<Integer, Integer> entry1:statics.entrySet()){
            //优先队列里只记录了前k频繁的数
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
