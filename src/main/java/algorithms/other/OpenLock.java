package algorithms.other;

import java.util.*;

/**
 * Created by yangyuan on 2021/3/27.
 * 752. 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target)) return 0;
        Set<String> s= new HashSet<>();
        for (String t:deadends) s.add(t);
        if (s.contains(start)) return -1;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        while (q.size() > 0){
            String e = q.poll();
            for (int i = 0; i < 4; i++){
                for (int j = -1; j <= 1; j +=2){
                    char[] state = e.toCharArray();//这个不能放在外层。 每次都要在新值上做变化
                    state[i] = (char)((state[i] - '0' + j + 10)%10 + '0');
                    String temp = new String(state);
                    if ((!dist.containsKey(temp) || dist.get (temp) == 0)  && !s.contains(temp)){
                        dist.put(temp, dist.get(e) + 1);
                        if (temp.equals(target)) return dist.get(temp);
                        q.add(temp);
                    }
                }
            }
        }
        return -1;
    }
}
