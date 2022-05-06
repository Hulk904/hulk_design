package algorithms.top100;

import java.util.ArrayDeque;

/**
 * Created by yangyuan on 2020/2/8.
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。

 示例 1 :

 输入: 2736
 输出: 7236
 解释: 交换数字2和数字7。

 最开始想的比较简单就是找到最大的数字然后和第一个交换，显然  98368 过不了
 主体思路就是找到数字中递减的序列，
 然后遍历找到之前较小的数，与之交换

 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {
        if (num <= 10){
            return num;
        }
        char[] str = (num + "").toCharArray();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++){
            if (max.isEmpty()){
                max.add(i);
                continue;
            }
            while (!max.isEmpty() && str[max.peekLast()] <= str[i]){
                max.pollLast();
            }
            max.add(i);
        }
        while (!max.isEmpty()){
            Integer index = max.pollFirst();
            int minIndex = minIndex(str, index);
            if (minIndex == -1){
                continue;
            }
            char temp = str[index];
            str[index] = str[minIndex];
            str[minIndex] = temp;
            return Integer.parseInt(new String(str));
        }
        return num;
    }

    private static int minIndex(char[] nums, int maxIndex){
        for (int i = 0; i < maxIndex; i++){
            if (nums[i] < nums[maxIndex]){
                return i;
            }
        }
        return -1;//没找到
    }


    //从左往右扫描， 找到一个升序点
    //然后 在右边找到最后最大的个数 x
    //左边找到第一个 比 x大的数 进行交换
    public int maximumSwap2(int num) {
        char[] s = ("" + num).toCharArray();;
        for (int i = 0; i + 1 < s.length; i++){
            if (s[i] < s[i + 1]){
                int k = i + 1;
                for (int j = k; j < s.length; j++){
                    if (s[j] >= s[k]){
                        k = j;//找到最后一个
                    }
                }
                for (int j = 0; ; j++){
                    if (s[j] < s[k]){
                        char temp = s[j];
                        s[j] = s[k];
                        s[k] = temp;
                        return Integer.parseInt(new String(s));
                    }
                }
            }
        }
        return num;
    }


}
