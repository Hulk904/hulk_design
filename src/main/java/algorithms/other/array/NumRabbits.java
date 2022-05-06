package algorithms.other.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/4/12.
 * 781. 森林中的兔子
 *
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

 返回森林中兔子的最少数量。

 */
public class NumRabbits {

    public int numRabbits(int[] answers) {
        //回答结果不一样，必然属于不同的组。所以可以独立的考虑每一组（组与组之间是独立的）
        //官方解答 &&
        // a/b 上取整等于  a+b - 1 / b  下取整
        Map<Integer, Integer> cnt = new HashMap();
        for (int i:answers) cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        int res = 0;
        for (Map.Entry<Integer,Integer> en:cnt.entrySet()){
            res += (en.getKey() + en.getValue())/(en.getKey() + 1)*(en.getKey() + 1);
        }
        return res;
    }
}
