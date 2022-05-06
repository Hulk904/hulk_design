package algorithms.other.btree;

import algorithms.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangyuan on 2021/11/28.
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。

 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。

 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。

 */
public class NextLargerNodes {

    // 单调栈
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList();
        for (ListNode p = head; p != null; p = p.next){
            list.add(p.val);
        }
        Stack<Integer> stack = new Stack();
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--){
            int x = list.get(i);
            while(stack.size() > 0 && x >= stack.peek()) stack.pop();
            if (stack.size() > 0 ) res[i] = stack.peek();
            else res[i] = 0;
            stack.push(x);
        }
        return res;
    }
}
