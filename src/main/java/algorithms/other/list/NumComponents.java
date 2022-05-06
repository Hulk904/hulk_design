package algorithms.other.list;

import algorithms.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yangyuan on 2021/5/9.
 * 817. 链表组件
 *
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。

 同时给定列表 G，该列表是上述链表中整型值的一个子集。

 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。

 */
public class NumComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for(int i:G){
            set.add(i);
        }
        int res = 0, s = 0;
        for (ListNode p = head;p != null; p = p.next){
            if (set.contains(p.val))s++;
            else {
                if (s > 0){
                    s = 0;
                    res++;
                }
            }
        }
        if (s > 0) res++;
        return res;
    }
}
