package algorithms.other.bfs;

import java.util.*;

/**
 * Created by yangyuan on 2020/10/24.
 * 433. 最小基因变化
 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

 */
public class MinMutation {

    /**
     * 图论
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        Set<String> s = new HashSet<>();
        for (String t:bank) s.add(t);
        Map<String, Integer> dist = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        dist.put(start, 0);
        char [] cs = {'A', 'T', 'C', 'G'};
        while (!queue.isEmpty()){
            String cur = queue.pollFirst();
            for (int i = 0; i < cur.length(); i++){
                for (char c:cs){
                    String temp = cur.substring(0,i) + c + cur.substring(i + 1);//下一点
                    if (s.contains(temp) && dist.get(temp) == null){
                        dist.put(temp, dist.get(cur) + 1);//到temp的距离
                        if (temp.equals(end)) return dist.get(temp);//找到了
                        queue.addLast(temp);
                    }
                }

            }
        }
        return -1;
    }

}
