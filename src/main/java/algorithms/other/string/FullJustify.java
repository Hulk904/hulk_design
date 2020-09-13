package algorithms.other.string;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangyuan on 2020/7/4.
 *
 * 68. 文本左右对齐
 *
 *
 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

 文本的最后一行应为左对齐，且单词之间不插入额外的空格。

 说明:

 输入单词数组 words 至少包含一个单词。
 */
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++){
            int j = i + 1;
            int len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth){
                len += 1 + words[j++].length();
            }
            sb.setLength(0);
            if (j == words.length || j == i + 1){//左对齐  最后一行 或者 一行只有一个单词
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(" " + words[k]);
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {//左右对齐
                int cnt = j - i - 1, r = maxWidth - len + cnt;
                sb.append(words[i]);
                int k = 0;
                while (k < r % cnt) {
                    sb.append( String.join("", Collections.nCopies( r/cnt + 1, " ")) + words[i + k + 1]);
                    k++;
                }
                while (k < cnt){
                    sb.append(String.join("", Collections.nCopies(r/cnt, " ")) + words[i + k + 1]);
                    k++;
                }
            }
            res.add(sb.toString());
            i = j - 1;
        }
        return res;
    }
}
