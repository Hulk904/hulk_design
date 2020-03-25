package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/2/24.
 * 525
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。

  

 示例 1:

 输入: [0,1]
 输出: 2
 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。

 */
public class FindMaxLength {

    public static void main(String[] args) {
        int[] data = {0,1,0};
        System.out.println(findMaxLength(data));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);//注意初始化
        Integer sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0 ? -1 : nums[i]);
            if (map.containsKey(sum)){
                result = Math.max(result, i -map.get(sum));
            } else {
                map.put(sum, i);//记录最早出现的下标
            }
        }
        return result;
    }
}
