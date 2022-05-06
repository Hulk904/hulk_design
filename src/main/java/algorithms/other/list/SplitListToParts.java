package algorithms.other.list;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2021/3/20.
 * 725. 分隔链表
 *
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

 返回一个符合上述规则的链表的列表。

 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        for (ListNode p = root; p != null; p = p.next) n++;
        ListNode[] res = new ListNode[k];
        ListNode p = root;
        for (int i = 0; i < k; i++){
            int len = n /k;
            if (i + 1 <= n%k) len++;
            res[i] = p;
            for (int j = 0; j < len - 1; j++) p = p.next;
            if (p != null){
                ListNode q = p.next;
                p.next = null;
                p = q;
            }
        }
        return res;
    }
}
