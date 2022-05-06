package algorithms.other;

import javax.lang.model.type.IntersectionType;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/6/5.
 * 898. 子数组按位或操作
 *
 * 我们有一个非负整数数组 A。

 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。

 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）



 */
public class SubarrayBitwiseORs {
    public int subarrayBitwiseORs(int[] arr) {
        //最多也就三十种情况， 每或操作一次就减少了一个bit位
        Set<Integer> res = new HashSet<>(), f = new HashSet<>()/*前一种状态*/, g = new HashSet<>()/*当前*/;
        for (int x:arr){
            g.add(x);
            for (Integer y:f) g.add(x|y);
            res.addAll(g);
            f = g;
            g = new HashSet();//这里不能用 g.clear();
        }
        return res.size();
    }
}
