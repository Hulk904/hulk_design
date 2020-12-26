package algorithms.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2020/4/12.
 * 556. 下一个更大元素 III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 *
 */
public class NextGreaterElement2 {

    /**
     * 同 31 题
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList();
        while (n > 0){
            list.add(n%10);
            n=n/10;
        }
        //找到递减的数索引
        int decIndex = -1;
        for (int i = 0; i < list.size(); i++){
            if (i + 1 < list.size() && list.get(i + 1) < list.get(i)){
                decIndex = i + 1;
                break;
            }
        }
        if (decIndex == -1) return -1;
        //找到第一个大于 decIndex 的数字
        int target = -1;
        for (int i = 0; i < decIndex; i++){
            if (list.get(i) > list.get(decIndex)){
                target = i;
                break;
            }
        }
        //交换 decIndex 和 target的数字
        int temp = list.get(decIndex);
        list.set(decIndex, list.get(target));
        list.set(target, temp);
        int l = 0, r = decIndex - 1;
        //把decIndex后的数据做递减处理（因为已经有序，所以两两交换即可）
        while (l < r){
            int tt = list.get(l);
            list.set(l, list.get(r));
            list.set(r, tt);
            l++;
            r--;
        }
        long res = 0;
        for (int i = list.size() - 1; i >= 0; i--){
            res = res*10 + list.get(i);
        }
        if (res > Integer.MAX_VALUE){
            return -1;
        }
        return (int)res;
    }
}
