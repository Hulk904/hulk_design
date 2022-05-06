package algorithms.other.string;

import java.util.Arrays;

/**
 * Created by yangyuan on 2021/6/6.
 * 899. 有序队列
 *
 给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。

 在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。

 返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。
 */
public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1){
            String res = s;
            for (int i = 0; i < s.length(); i++){
                s = s.substring(1, s.length()) + s.charAt(0);
                res = res.compareTo(s) > 0 ? s : res;
            }
            return res;
        }
        //当k 大于等于2 时 ，s可以变为任意的字符串。 （类比冒泡排序）
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
