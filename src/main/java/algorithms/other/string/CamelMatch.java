package algorithms.other.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/12/4.
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。
 * （我们可以在任何位置插入每个字符，也可以插入 0 个字符。）

 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。
 只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

 */
public class CamelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList(queries.length);
        for (String q:queries){
            res.add(check(q, pattern));
        }
        return res;
    }
    //双指针  匹配
    // 当a中的字符不存在b中，且为大写字符时  说明 不匹配
    boolean check(String a, String b){
        int j = 0;
        for (char c:a.toCharArray()){
            if (j < b.length() && c == b.charAt(j)) j++;
            else if (c < 'a'){
                return false;
            }
        }
        return j == b.length();
    }
}
