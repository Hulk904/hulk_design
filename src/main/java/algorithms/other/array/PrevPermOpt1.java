package algorithms.other.array;

/**
 * Created by yangyuan on 2021/12/20.
 * 1053. 交换一次的先前排列
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。

 如果无法这么操作，就请返回原数组。

 */
public class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i>= 0; i--){
            if (arr[i] > arr[i + 1]){
                int j = i + 1;
                while (j + 1 < n && arr[j + 1] < arr[i]) j++;
                while (arr[j - 1] == arr[j]) j--;//多个相同值取第一个
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                return arr;
            }
        }
        return arr;
    }
}
