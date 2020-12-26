package algorithms.other.string;

/**
 * Created by yangyuan on 2020/11/21.
 * 520. 检测大写字母
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。

 我们定义，在以下情况时，单词的大写用法是正确的：

 全部字母都是大写，比如"USA"。
 单词中所有字母都不是大写，比如"leetcode"。
 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 否则，我们定义这个单词没有正确使用大写字母。

 */
public class DetectCapitalUse {

    /**
     * 模拟题
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        //统计大写字符个数。如果等于长度、或者等于0、或者等于1并且首字母大写
        int c = 0;
        for (char a:word.toCharArray()){
            if (check(a)){
                c++;
            }
        }
        return c == word.length() || c == 0 || (c == 1 && check(word.charAt(0)));
    }

    private  boolean check(char c){
        return c >= 'A' && c <= 'Z';
    }

    //比较丑陋的实现。。
    public boolean detectCapitalUse2(String word) {
        if (check(word.charAt(0))){
            if (word.length() > 1){
                return checkSame(word, 1);
            }
            return true;
        }
        return checkSame(word, 0);
    }

    private boolean checkSame(String s, int start){
        boolean flag = check(s.charAt(start));
        if (flag){
            for (int i = start; i < s.length(); i++){
                if (!check(s.charAt(i))){
                    return false;
                }
            }
        } else {
            for (int i = start; i < s.length(); i++){
                if (check(s.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }


}
