package algorithms.other;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/3/3.
 * 784. 字母大小写全排列
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 */
public class LetterCasePermutation {

    List<String> result = new ArrayList();

    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        List<String> list = l.letterCasePermutation("1a2b");
        System.out.println(JSON.toJSONString(list));
    }

    public List<String> letterCasePermutation(String S) {
        dfs(S, 0);
        return result;
    }

    void dfs(String s, int pos){
        if (pos == s.length()){
            result.add(s);
            return;
        }
        dfs(s, pos + 1);//数字或字母可能都不会变
        //如果是字母变换大小写
        if (s.charAt(pos) >= 'A'){
            char newChar = (char)(s.charAt(pos)^32);//字符大小写切换
            s = s.substring(0, pos) + newChar + s.substring(pos + 1, s.length());
            //s每次都是新生成的所以不需要状态恢复？？
            dfs(s, pos + 1);
        }
    }


}
