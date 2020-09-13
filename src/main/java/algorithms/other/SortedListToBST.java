package algorithms.other;

import algorithms.ListNode;
import algorithms.TreeNode;

/**
 * Created by yangyuan on 2020/3/25.
 *
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。


 这题思路之一可以套用 有序数组转二叉搜索数  先将链表转数组
 */
public class SortedListToBST {

    /**
     * 不用额外空间，时间复制度nlogn
     * 保证左边不空
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int n = 0;
        for (ListNode temp = head; temp != null; temp = temp.next) n++;
        if (n == 1) return new TreeNode(head.val);
        ListNode cur = head;
        for (int i = 0; i < n / 2 - 1; i++) cur = cur.next;//指向中间的前一个点
        TreeNode root = new TreeNode(cur.next.val);
        root.right = sortedListToBST(cur.next.next);
        cur.next = null;//因为保证了左边不空
        root.left = sortedListToBST(head);
        return root;
    }
}
