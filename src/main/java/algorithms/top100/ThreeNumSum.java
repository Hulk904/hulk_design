package algorithms.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2019/12/28.
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 思路： 排序 按一点不动， 另外两个点从右边界向内收敛缩小范围。。。
 注意：答案中不可以包含重复的三元组
 特殊情况  0，0，0，0
         考虑重复的情况 卯点元素和两外两个重复处理逻辑稍有不同
 */
public class ThreeNumSum {

    public static void main(String[] args) {

        int[] array = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeNumSum(array));

    }

    private static List<List<Integer>> threeNumSum(int[] array){
        if (array == null || array.length < 2){
            return new ArrayList<>();
        }
        Arrays.sort(array);
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(array[i] <=0 && i < array.length - 2){
            if (i-1 >= 0 && array[i] == array[i -1]){
                i++;
                continue;
            }
            for(int left = i +1, right = array.length -1; left < right;) {
                if (left -i > 1 && left-1>=0 && array[left] == array[left -1]){
                    left++;
                    continue;
                }
                if (right + 1 < array.length && array[right] == array[right + 1]) {
                    right--;
                    continue;
                }
                if (array[i] + array[left] + array[right] == 0) {

                    List<Integer> item = new ArrayList<>();
                    item.add(array[i]);
                    item.add(array[left]);
                    item.add(array[right]);
                    result.add(item);
                    left++;
                    right--;
                } else {
                    if (array[i] + array[left] + array[right] > 0){
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            i++;
        }
        return result;
    }
}
