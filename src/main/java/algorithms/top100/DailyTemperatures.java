package algorithms.top100;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * Created by yangyuan on 2020/1/19.
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] data = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(JSON.toJSONString(dailyTemperatureStack2(data)));

    }


    //第二次重写
    public static int[] dailyTemperatureStack2(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]){//注意等号
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }



    /**
     * 使用栈记录大于当前数据的数
     * 从后往前遍历，栈中存放比当前元素的下标。。
     * @param T
     * @return
     */
    public static int[] dailyTemperatureStack(int[] T){
        int[] res = new int[T.length];
        Stack<Integer> maxIndex = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--){
            while (!maxIndex.isEmpty() && T[i] >= T[maxIndex.peek()]){
                maxIndex.pop();
            }
            res[i] = maxIndex.isEmpty() ? 0 : maxIndex.peek() - i;
            maxIndex.push(i);
        }
        return res;
    }

    /**
     * 相对于 n2的算法
     * 从后往前计算。并且跳过重复的部分   时间甚至比栈要快啊。。
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = result.length - 2; i >= 0; i--){
            for (int j = i + 1; j < result.length; j+=result[j]){//跳过重复计算的部分:利用已有的结果进行跳跃
                if (T[i] < T[j]){
                    result[i] = j -i;
                    break;
                }
                if (result[j] == 0){
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

}
