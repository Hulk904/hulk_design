package algorithms.other.array;

/**
 * Created by yangyuan on 2020/9/12.
 * 307. 区域和检索 - 数组可修改
 *给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 *update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

 */
public class NumArray2 {

    // 树状树组 支持两个操作  求前缀和 ， 给某个位置加上一个数
    int n;
    int[] tr;
    int[] nums;

    int lowbit(int x){
        return x & -x;
    }

    //前缀和
    int query(int x){
        int res = 0;
        for (int i = x; i > 0; i-=lowbit(i)) res +=tr[i];
        return res;
    }
    //给某个位置加上某个数
    void add( int x, int v){
        for (int i = x; i <= n; i+= lowbit(i)) tr[i] += v;
    }
    public NumArray2(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        tr = new int [n + 1];
        for (int i=  1; i <= n; i++){
            tr[i] = nums[i - 1];
            for (int j = i - 1; j > i - lowbit(i); j-=lowbit(j)){
                tr[i] += tr[j];
            }
        }
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);
    }
}
