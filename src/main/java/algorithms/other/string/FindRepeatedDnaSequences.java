package algorithms.other.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yangyuan on 2020/8/8.
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。



 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> all = new HashSet<>();
        Set<String> res = new HashSet<>();
        for(int i = 0; i + 10 <= s.length(); i++){
            if (all.contains(s.substring(i, i + 10))){
                res.add(s.substring(i, i + 10));
                continue;
            }
            all.add(s.substring(i, i + 10));
        }
        return new ArrayList<>(res);
    }
}
