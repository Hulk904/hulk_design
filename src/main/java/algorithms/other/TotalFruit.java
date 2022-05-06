package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2021/6/12.
 * 904. 水果成篮
 *
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 你可以从你选择的任何树开始，然后重复执行以下步骤：

 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。

 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。

 用这个程序你能收集的水果树的最大总量是多少？

 */
public class TotalFruit {
    public int totalFruit(int[] tree) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap();
        for (int i = 0, j = 0, s = 0; i < tree.length; i++){
            cnt.put(tree[i], cnt.getOrDefault(tree[i], 0) + 1);
            if (cnt.get(tree[i]) == 1){
                s++;//s 记录不同元素个数
            }
            while (s > 2){
                cnt.put(tree[j], cnt.getOrDefault(tree[j], 0) - 1);
                if (cnt.get(tree[j]) == 0) s--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
