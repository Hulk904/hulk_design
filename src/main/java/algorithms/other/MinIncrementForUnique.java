package algorithms.other;

/**
 * Created by yangyuan on 2020/4/26.
 * 945. 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */
public class MinIncrementForUnique {

    /**
     * 计数排序
     * 这个统计的思路是：如果当前元素有多个，那么把这些元素都置为0（减去变化次数），
     * 当出现空位时，加上空位对应的值，然后把之前重复统计的次数减1
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int[] sta = new int[80000];
        int times = 0;
        int taken = 0;
        for (int a:A){
            sta[a]++;
        }
        for (int i = 0; i < sta.length; i++){
            int item = sta[i];
            if (item >= 2){
                taken += item - 1;
                times -= (item - 1)*i;
            }
            if (taken > 0 && item == 0){
                taken--;
                times += i;
            }
        }
        return times;
    }

    /**
     * 计数排序思路2
     * 当元素个数大于2的时候，把多的元素都往后移动一个位置，直到遍历完数组
     * 当然了这里还有优化的空间，比如统计出 最大值，这样不用遍历完整个数组，同时数组空间还可以减半
     * @param A
     * @return
     */
    public int minIncrementForUnique2(int[] A) {
        int[] sta = new int[80001];
        for (int a:A){
            sta[a]++;
        }
        int res = 0;
        for (int i = 0; i < sta.length; i++){
            int item = sta[i];
            if (item >= 2){
                res += item - 1;
                sta[i + 1] += item - 1;
            }
        }
        return res;
    }

}
