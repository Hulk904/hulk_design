package algorithms.other;

import algorithms.ListNode;

/**
 * Created by yangyuan on 2020/3/1.
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        //自己想的居然是把所有的元素都往前移动一步，然后删掉
        //最后的一个节点。。怎么这么笨啊。。想的太麻烦了
        // ListNode next = node.next;
        // while(node.next != null){
        //     node.val = next.val;
        //     next = next.next;
        //     if (next == null){
        //         node.next = null;
        //     } else {
        //         node = node.next;
        //     }

        // }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
