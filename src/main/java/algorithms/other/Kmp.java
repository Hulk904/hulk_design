package algorithms.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/29.
 *
 * kmp 算法
 */
public class Kmp {

    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        System.out.println(JSON.toJSONString(kmp.kmp(",tencent", "tencent")));
    }

    private List<Integer> kmp(String s, String p){
        List<Integer> res = new ArrayList<>();
        int[] next = next(p);
        /*
         * kmp 匹配过程  字符下标从0开始
         */
        for(int i = 0, j = -1; i < s.length(); i++){
            //注意和s匹配的是j+1 （预匹配）
            while (j >= 0 && s.charAt(i) != p.charAt(j + 1)) {
                j = next[j];//匹配不上，模式串退一步
            }
            //上面while退出两种情况，这里是两个匹配上了
            if (s.charAt(i) == p.charAt(j + 1)) j++;//元素匹配 ---> 到下一个元素
            if (j == p.length() - 1){//匹配成功
                res.add(i - j);
                j = next[j];//匹配成功后 后退一步重置下
            }
        }
        return res;

    }

    /**
     * 求 next
     * 过程和上面的匹配流程类似，只是 p自己和自己比较而已
     * @param p
     * @return
     */
    private int[] next(String p){
        int[] next = new int[p.length()];
        Arrays.fill(next, -1);
        //i从1开始， 0 为 -1
        for(int i = 1, j = -1; i < p.length(); i++){
            while (j >= 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];//不匹配
            if (p.charAt(i) == p.charAt(j + 1)) j++;
            next[i] = j;//记录一下
        }
        return  next;
    }
}
