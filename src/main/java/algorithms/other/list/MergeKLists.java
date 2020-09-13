package algorithms.other.list;

import algorithms.ListNode;

import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2020/6/20.
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class MergeKLists {


    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        ListNode b = new ListNode(2);
        b.next = a;
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(4);
        d.next = c;
        ListNode[] list = new ListNode[2];
        list[0] = b;
        list[1] = d;
        mergeKLists(list);
    }

    /**
     * 使用优先队列（默认小顶堆），里面存放的是ListNode ，所有需要重写比较器
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++){
            if (lists[i] == null) continue;
            priorityQueue.add(lists[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            cur.next = temp;
            cur = cur.next;
            temp = temp.next;
            if (temp != null){
                priorityQueue.add(temp);
            }
        }
        return dummy.next;
    }
}
