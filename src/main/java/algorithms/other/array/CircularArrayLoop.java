package algorithms.other.array;

/**
 * Created by yangyuan on 2020/10/31.
 *
 * 457. 环形数组循环
 *
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
  
 */
public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int span = 10000;
        for (int i = 0; i < n; i++){
            if (nums[i] >= span) continue;
            int k = i, s = span + i;
            int  t = nums[k] > 0 ? 1 : 0;
            int last = -1;//最后一个位置
            do {
                int p = ((k + nums[k])%n + n)%n;//下一跳位置
                last = nums[k];//
                nums[k] = s;//标记下
                k = p;
            } while (k != i && nums[k] < span && /*没有遍历到重复元素*/ (t ^ (nums[k] > 0 ? 1 : 0)/*符号相同*/) == 0);
            if ((last%n) != 0/*没有自环*/ && nums[k] == s) return true;
        }
        return false ;
    }
}
