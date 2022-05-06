package algorithms.other.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangyuan on 2020/12/27.
 * 648. 单词替换
 *
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。

 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，
 则用最短的词根替换它。

 你需要输出替换之后的句子。

 */
public class ReplaceWords {

    /**
     * 字符串哈希
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<Long> set = new HashSet();
        int P = 131; //131  或者 13331
        for (String d:dictionary){
            long h = 0;
            for (char c:d.toCharArray()) h = h*P + c;
            set.add(h);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++){
            int j = i;
            while (j < sentence.length() && sentence.charAt(j) != ' ')j++;
            long h = 0;
            for (int k = i; k < j; k++){
                sb.append(sentence.charAt(k));
                h = h*P + sentence.charAt(k);
                if (set.contains(h))break;
            }
            sb.append(" ");
            i = j;
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
