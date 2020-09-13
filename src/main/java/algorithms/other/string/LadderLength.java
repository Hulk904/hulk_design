package algorithms.other.string;

import java.util.*;

/**
 * Created by yangyuan on 2020/7/25.
 *
 * 127. 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。


 */
public class LadderLength {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{add("a");add("b");add("c");}};
        ladderLength("a", "c", list);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hashSet = new HashSet<>();
        for (String s:wordList){
            hashSet.add(s);
        }
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        LinkedList<String>  q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()){
            String t = q.removeFirst();
            String r = t;
            for (int i = 0; i < t.length(); i++){
                t = r;
                for (char j = 'a'; j <= 'z'; j++){
                    t = t.substring(0, i) + j + t.substring(i + 1);
                    if (hashSet.contains(t) && (dist.get(t) == null || dist.get(t) == 0)){
                        dist.put(t, dist.getOrDefault(r, 0) + 1);
                        if (t.equals(endWord)) return dist.get(t) + 1;
                        q.addLast(t);//q.push 不行 push是addFirst
                    }
                }
            }
        }
        return 0;
    }
}
