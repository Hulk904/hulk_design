package algorithms.other.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yangyuan on 2021/11/21.
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，
 * 然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

 以这种方式修改数组后，返回数组可能的最大和。

 */
public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min = 1000;
        for (int i:nums){
            min = Math.min(min, Math.abs(i));
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = -100; i < 0 && k > 0; i++){
            while (map.get(i) != null && map.get(i) > 0 && k > 0){
                map.put(i, map.get(i) - 1);
                map.put(-i, map.getOrDefault(-i, 0) + 1);
                k--;
            }
        }
        int res = 0;
        for (int i = -100; i <= 100; i++){
            res += i*map.getOrDefault(i, 0);
        }
        if(k%2 > 0)res -= 2*min;
        return res;
    }

    public int largestSumAfterKNegationsErr(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min = 1000;
        //数据数比较大但是值数少可以选择桶排序 如上
        for (int i:nums){
            min = Math.min(min, Math.abs(i));
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 运行时报错， 遍历时修改了
        for (Map.Entry<Integer, Integer> en:map.entrySet()){
            int c = en.getValue();
            while (c-- > 0 && k > 0){
                map.put(en.getValue(), c);
                map.put(-en.getValue(), map.getOrDefault(-en.getValue(), 0) + 1);
                k--;
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> en:map.entrySet()){
            res += en.getKey()*en.getValue();
        }
        if(k%2 > 0)res -= 2*min;
        return res;
    }
}
