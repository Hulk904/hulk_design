package algorithms.other.list;

import algorithms.ListNode;

import java.util.Random;

/**
 * Created by yangyuan on 2020/10/2.
 *
 * 382. 链表随机节点
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 *     //背过
*      //蓄水池抽样算法
 */
public class GetRandom {

    ListNode h;

    Random random ;

    public GetRandom(ListNode head) {
        this.h = head;
        this.random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int c = -1;
        int n = 0;
        for (ListNode p = h; p != null; p = p.next){
            n++;
            if (random.nextInt(n) % n == 0) c = p.val;
        }
        return c;
    }
}
