package algorithms.toutiao;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/2/2.
 *
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

 你需要按照以下要求，帮助老师给这些孩子分发糖果：

 每个孩子至少分配到 1 个糖果。
 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 那么这样下来，老师至少需要准备多少颗糖果呢？

 示例 1:

 输入: [1,0,2]
 输出: 5
 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。

 */
public class Candy {

    public static void main(String[] args) {
        int[] data = {1,0,2};
        System.out.println(candy(data));
    }

    /**
     * 从左往右遍历计算一遍左依赖的数据
     * 从右往左遍历计算一遍右依赖的数据
     * 然后对每个坐标i 取 Math.max(left[i], right[i]） 累加和  。。。
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        if (ratings.length == 0){
            return 0;
        }
        if (ratings.length == 1){
            return 1;
        }
        int[] left = new int[ratings.length];
        Arrays.fill(left, 1);
        int[] right = new int[ratings.length];
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < ratings.length; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
