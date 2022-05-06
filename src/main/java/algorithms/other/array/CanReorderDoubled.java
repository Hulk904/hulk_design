package algorithms.other.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by yangyuan on 2021/7/4.
 * 954. 二倍数对数组
 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
 都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。

 */
public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] b = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++){
            b[i] = arr[i];
        }
        Arrays.sort(b, Comparator.comparingInt(Math::abs));
        for (int i:b){
            if (map.getOrDefault(i, 0) == 0)continue;//1注意这两行
            if (map.getOrDefault(i*2, 0) <= 0) return false;//2
            map.put(i, map.getOrDefault(i, 0) - 1);
            map.put(i*2, map.getOrDefault(i*2, 0) - 1);
        }
        return true;
    }
}
