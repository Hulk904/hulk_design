package algorithms.top100;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/26.
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

 示例 1:

 输入: 4->2->1->3
 输出: 1->2->3->4
 */
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1= new ListNode(5);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3= new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(0);
        node3.next = node4;
        System.out.println(JSON.toJSONString(sortListTimes2(head)));
    }


    /**
     * 找到中间分割点，把连表分为两个  然后归并排序
     * 与数组不一样的，连表不需要辅助空间
     * 使用到了栈，其实是不满足的。
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next, slow = head;// 如果这里初始化fast=head那么 递归将会死循环 大小为2的不能分为 1 和1 的连表
        while (fast != null && fast.next != null){//这里只用判断fast就行了
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode p2 = sortList(head);
        ListNode p1 = sortList(temp);
//        sortList(head);
//        sortList(temp);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2 : p1;
        return result.next;
    }

    /**
     * 迭代实现， 常数空间
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {

        ListNode temp = head;
        int lenght = 0;
        while (temp != null){
            temp = temp.next;
            lenght++;
        }
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        for (int i = 1; i < lenght; i *=2){//i 相当于一个区间的长度，一次比较两个区间的数据
            ListNode cur = dummy;
            for (int j = 0; j + i < lenght; j += i*2){// 比较之后每次跨越两个区间
                //这里得注意。 不要写成 ListNode cur = dummy.next,  然后这里初始化 left= cur, right = cur 这样是不对的
                //在内层for循环，cur指向的是比完数据的点， 所以下一轮当然得从cur.next开始。。。
                ListNode left = cur.next, right = cur.next;
                for (int k = i; k > 0; k--){
                    right = right.next;
                }
                int l = 0, r = 0;//下标
                //比较两个连表
                while (l < i && r < i && right != null){
                    if (left.val > right.val){
                        cur.next = right;
                        cur = right;
                        right = right.next;
                        r++;
                    } else {
                        cur.next = left;
                        cur = left;
                        left = left.next;
                        l++;
                    }
                }
                //左边的没有走完呢，后序给连上
                while (l < i){
                    cur.next = left;
                    cur = left;
                    left = left.next;
                    l++;
                }
                //同理右边没有走完的给串上
                while (r < i && right != null){
                    cur.next = right;
                    cur = right;
                    right = right.next;
                    r++;
                }
                cur.next = right;//和下一个区间连上
            }
        }
        return dummy.next;
    }

    public static ListNode sortListTimes2(ListNode head) {
        if (head == null){
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < length; i*=2){
            ListNode cur = dummy;
            for (int j = 0; j + i < length; j+=2*i){
                int l = 0, r = 0;
                ListNode left = cur.next, right = cur.next;
                int k = i;
                while(k > 0){
                    k--;
                    right = right.next;
                }

                while ( l < i && r < i && right != null){
                    if (left.val < right.val){
                        l++;
                        cur.next = left;
                        cur = left;
                        left = left.next;
                    } else {
                        r++;
                        cur.next = right;
                        cur = right;
                        right = right.next;
                    }
                }
                while (l < i){
                    l++;
                    cur.next = left;
                    cur = cur.next;
                    left = left.next;
                }
                while ( r < i && right != null){
                    r++;
                    cur.next = right;
                    cur = cur.next;
                    right = right.next;
                }
                cur.next = right;
            }
        }
        return dummy.next;
    }
}
