package algorithms.top100;

/**
 * Created by yangyuan on 2019/12/31.
 *
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

   数组中的每个元素代表你在该位置可以跳跃的最大长度。

   判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。


 */
public class CanJump {


    public static void main(String[] args) {
        int[] data = {3,2,1,0,4};
        System.out.println(canJump1(data));
    }

    /**
     * 动态规划改造
     * 相比下面的回溯  主流程差不多。只是记录中间结果。
     * 相比而言会快点，但是还是比贪心慢不少
     * @param nums
     * @return
     */
    private static boolean canJump(int[] nums){
        int[] flag = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            flag[i] = 0;
        }
        flag[nums.length - 1] = 1;
        return canJumpFromPosition(0, nums, flag);
    }

    private static boolean canJumpFromPosition(int curPosition, int[] nums, int[] flag){
        if (flag[curPosition] != 0){
            return flag[curPosition] == 1 ? true : false;
        }
        int maxLength = nums[curPosition] + curPosition;
        if (maxLength >= nums.length -1){
            return true;
        }
        for (int i = curPosition + 1; i<= maxLength; i++){
            if (canJumpFromPosition(i, nums, flag)){
                flag[curPosition] = 1;
                return true;
            }
        }
        flag[curPosition] = -1;
        return false;
    }


    /**
     * 回溯  实现  leetcode上跑会超时
     * @param nums
     * @return
     */
    private static boolean canJump2(int[] nums){
        return canJumpFromPosition2(0, nums);
    }

    private static boolean canJumpFromPosition2(int curPosition, int[] nums){
        if (curPosition == nums.length -1){
            return true;
        }
        int maxLength = nums[curPosition] + curPosition;
        if (maxLength >= nums.length -1){
            return true;
        }
        for (int i = curPosition + 1; i<= maxLength; i++){
            //注意 因为只需要一个可以就行   如果直接写return canJumpFromPosition(i, nums) 是有问题的，
            //第一个失败但是后面的有可以的 就有问题了。
            if (canJumpFromPosition2(i, nums)){
                return true;
            }
        }
        return false;
    }


    /**
     * 贪心算法实现
     * @param nums
     * @return
     */
    private static boolean canJump1(int[] nums){
        if (nums.length <= 1){
            return true;
        }
        int lastPos = nums.length - 1;
        for (int i = nums.length -1; i >= 0 ;i--){
            if (nums[i] + i >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
