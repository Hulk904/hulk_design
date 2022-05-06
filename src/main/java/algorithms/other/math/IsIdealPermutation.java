package algorithms.other.math;

/**
 * Created by yangyuan on 2021/4/4.
 * 775. 全局倒置与局部倒置
 *
 * 数组 A 是 [0, 1, ..., N - 1] 的一种排列，N 是数组 A 的长度。全局倒置指的是 i,j 满足 0 <= i < j < N 并且 A[i] > A[j] ，局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1] 。

 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。


 */
public class IsIdealPermutation {

    // 数学题
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++){
            if (Math.abs(A[i] - i) > 1){
                return false;
            }
        }
        return true;
    }

}
