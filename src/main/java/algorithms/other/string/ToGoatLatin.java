package algorithms.other.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/5/11.
 * 824. 山羊拉丁文
 */
public class ToGoatLatin {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet(){{add('a');add('e');add('i');add('o');add('u');}};
        //模拟题
        StringBuilder sb = new StringBuilder();
        for (int i = 0, k = 1; i < sentence.length(); i++){
            int j = i + 1;
            while (j < sentence.length() && sentence.charAt(j) != ' ')j++;
            String word = sentence.substring(i, j);
            i = j;
            if (set.contains(Character.toLowerCase(word.charAt(0)))) word+="ma";
            else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            char[] ct = new char[k];
            Arrays.fill(ct, 'a');
            word += new String(ct);
            k++;
            sb.append(word).append(" ");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
