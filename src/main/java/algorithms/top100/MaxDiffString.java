package algorithms.top100;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2019/12/27.
 * 无重复字符的最长子串
 * 思路：滑动窗口
 *   存在的删除下标为i的元素 ，i++
 *   不存在的添加下标为j的元素 ，j++
 */
public class MaxDiffString {

    public static void main(String[] args) {

        String str = "pwwke";
        System.out.println(max(str));
    }

    private static int max(String str){
        if (StringUtils.isBlank(str)){
            return 0;
        }
        int i = 0, j = 0, r = 0;
        Set<Character> set = new HashSet<Character>();
        while (j < str.length()){
            if (set.contains(str.charAt(j))){
                set.remove(str.charAt(i ++));//注意删除的是 i 下标的元素
            }else {
                r = Math.max(r, j - i  + 1);
                set.add(str.charAt( j++));
            }
        }
        return r;
    }

}
