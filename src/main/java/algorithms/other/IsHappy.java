package algorithms.other;

/**
 * Created by yangyuan on 2020/4/19.
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。

 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。

 如果 n 是快乐数就返回 True ；不是，则返回 False 。

 */
public class IsHappy {

    /**
     *  最坏情况下n 为 9999999999 这个比Integer.MAX_VALUE 要大
     *  最大值为9*9 *10  最多只有811个不同的数
     * @param n
     * @return
     */
    public boolean isHappy2(int n){
        int c  = 1000;
        while (c > 0 && n != 1){
            n = cal(n);
            c--;
        }
        return n == 1;
    }

    /**
     * 跟链表里找环类似  最后的环里面的元素是1就是快乐数了。
     * @param n
     * @return
     */
    public  boolean isHappy(int n) {
        int fast = n, slow = n;
        do{
            fast = cal(cal(fast));
            slow = cal(slow);

        } while (fast != slow); //也可以变为 fast != slow && fast != 1
        return slow == 1;       //同理下面也要改为 return slow == 1 || fast == 1; 改了之后貌似也没有变快。。。
    }

    public boolean isHappy3(int n) {
        int slow = n;
        int fast = cal(n);
        while (slow != fast){
            slow = cal(slow);
            fast = cal(cal(fast));
        }
        return slow == 1;//最后在环里的数可能并不是1
    }

    private int cal (int n){
        int res = 0;
        while (n > 0){
            int y = n%10;
            res+=y*y;
            n = n/10;
        }
        return res;
    }
}
