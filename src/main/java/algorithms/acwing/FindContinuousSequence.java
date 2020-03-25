package algorithms.acwing;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/2/23.
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。

 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8

 跟829 差不多 只需要返回数量
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(findContinuousSequence(15)));
    }

    /**
     * 超时
     * @param sum
     * @return
     */
    public static List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1, j = 1, curSum = 1; i < sum; i++){
            while (curSum < sum){
                curSum += ++j;
            }
            if (curSum == sum && j-i >0){
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <= j; k++){
                    list.add(k);
                }
                result.add(list);
            }
            curSum-=i;
        }
        return result;
    }


}
