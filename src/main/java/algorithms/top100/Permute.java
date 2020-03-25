package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yangyuan on 2019/12/31.
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Permute {


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //System.out.println(JSON.toJSONString(permute(nums)));
        Permute permute = new Permute();
        permute.permute2(nums);
        System.out.println(JSON.toJSONString(permute.result));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();//存当前方案的

    boolean[] visited ;

    /**
     * 枚举每个位置放哪个数
     * @param nums
     * @return
     */
    public  List<List<Integer>> permute2(int[] nums){
        visited = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    /**
     *
     * @param nums
     * @param start 深度
     */
    public void dfs(int[] nums, int start){
        if (start == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //因为是对所有的数进行尝试，所以 i 每次都是从 0 开始 ，而不是start
        //一共27 搜索空间， 通过visited 剪枝 缩小空间
        for (int i = 0; i < nums.length; i++){
            if (!visited[i]) {//visisted 少不了啊
                // 也可以通过下面的方法进行剪枝， 这样就可以不需要visited标记是否选择过了。。。
                // path.contains(nums[i]);
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, start + 1);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
// 下面这样不行
//        for (int i = start; i < nums.length; i++){
//                path.add(nums[i]);
//                dfs(nums, start + 1);
//                path.remove(path.size() - 1);
//            }
//        }
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        doPermute(nums, result, 0);
        return result;
    }

    /**
     * 依次交换数组相关元素数据
     * @param nums
     * @param result
     * @param start
     */
    public static void  doPermute(int[] nums, List<List<Integer>> result, int start){
        if (start == nums.length -1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = start; i < nums.length; i++){
            swap(nums, start, i);
            doPermute(nums, result, start + 1);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
