package algorithms.other;

/**
 * Created by yangyuan on 2020/9/13.
 * 318. 最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
 * 并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

 */
public class MaxProduct2 {

    public int maxProduct(String[] words) {
        //n2 枚举是跑不了的  ， 需要快速的判断两个字符串有没有相同的字符
        int[] state = new int[words.length];
        //用一个int 记录每个字符中是否出现过字符的信息 。 因为只有26个字符
        for (int i = 0 ;i < words.length; i++){
            int s = 0;
            for (char c:words[i].toCharArray()){
                s |= 1<< (c - 'a');
            }
            state[i] = s;
        }
        int res = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if ((state[i] & state[j]) == 0){//两个字符串没有交集
                    res  = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
