package algorithms.other.array;

/**
 * Created by yangyuan on 2020/11/28.
 * 553. 最优除法
 *
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。

 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。

 */
public class OptimalDivision {

    /**
     * 要想除法结果最大，那么需要将更多的除法变为乘法。 怎么变为乘法? 比如 a/b/c  --> a(b/c)  相当于   a/b*c 了
     * 第二个树怎么也不能变为乘法，所以在第二个数和最后一个数加上括号
     *
     * 属于脑筋急转弯的题目
     * @param nums
     * @return
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 0) return "";
        if (n == 1) return nums[0] + "";
        if (n == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder(nums[0] + "/(");
        for (int i = 1; i < n - 1; i++){
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[n - 1] + ")");
        return sb.toString();
    }
}
