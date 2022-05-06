package algorithms.other.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/3/7.
 *
 * 682. 棒球比赛
 *
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

 整数 x - 表示本回合新获得分数 x
 "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 请你返回记录中所有得分的总和。

 */
public class CalPoints {

    //  用数组来模拟 栈。因为要取到倒数第二个数， 这样会方便一些
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList();
        for(String s:ops){
            int last = list.size() - 1;
            if (s.equals("+")){
                list.add(list.get(last - 1) + list.get(last));
            } else if (s.equals("D")){
                list.add(list.get(last)*2);
            } else if (s.equals("C")){
                list.remove(last);
            } else{
                list.add(Integer.parseInt(s));
            }
        }
        int res = 0;
        for (int i:list){
            res += i;
        }
        return res;
    }
}
