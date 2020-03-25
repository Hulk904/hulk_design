package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/26.
 * 679. 24 点游戏
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。

 示例 1:
 输入: [4, 1, 8, 7]
 输出: True
 解释: (8-4) * (7-1) = 24

 */
public class JudgePoint24 {

    public static void main(String[] args) {
        int[] data = {4, 1, 8, 7};
        System.out.println(judgePoint24(data));
    }

    public static boolean judgePoint24(int[] nums) {
        List<Double> data = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            data.add((double)nums[i]);
        }
        return doJudge(data);
    }

    public static boolean doJudge(List<Double> nums){
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1){
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < nums.size(); i++){
            for (int j = 0; j < nums.size(); j++){
                if (i != j){
                    List<Double> newNum = new ArrayList<>();
                    for (int m = 0; m < nums.size(); m++){
                        if (m != i && m != j){
                            newNum.add(nums.get(m));
                        }
                    }
                    for (int n = 0; n < 4; n++){
                        //第一个分支可以没有，剪枝主要是为了减少运算，
                        // 因为加法和乘法满足交换率
                        if (n < 2 & j > i){
                            continue;
                        } else if(n == 0){
                            newNum.add(nums.get(i) + nums.get(j));
                        } else if (n == 1){
                            newNum.add(nums.get(i)*nums.get(j));
                        } else if (n == 2){
                            newNum.add(nums.get(i) - nums.get(j));
                        } else if (n == 3){
                            if (nums.get(j) == 0){
                                continue;//注意1 不要写 return false
                            }
                            newNum.add(nums.get(i)/nums.get(j));
                        }
                        if (doJudge(newNum)){
                            return true;
                        }
                        newNum.remove(newNum.size() - 1); //注意二 不要漏掉
                    }
                }
            }
        }
        return false;
    }



}
