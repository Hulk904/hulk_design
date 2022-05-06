package algorithms.other.array;

/**
 * Created by yangyuan on 2021/11/27.
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。

 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。

 */
public class CanThreePartsEqualSum {

    /**
     * 思路不简单 但是写出下面简洁优雅的代码还是难的
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i:A) sum+=i;
        if (sum%3 != 0) return false;
        int i = 0, j = A.length - 1;
        for (int s =0; i < A.length; i++){
            s += A[i];
            if (s == sum/3) break;
        }
        for (int s = 0; j >= 0; j--){
            s += A[j];
            if (s == sum/3) break;
        }
        return i + 1 <= j - 1;
    }



    /**
     * 下面这个解法 0，0，0，0，0  case 通不过
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSumERR(int[] A) {
        int sum = 0;
        for (int i:A) sum+=i;
        if (sum%3 != 0) return false;
        int i = 0, j = A.length - 1;
        int temp = 0;
        for (int m = 0, t = 0; m < A.length; m++){
            if (t < sum/3) {
                t+= A[m];
                i = m;
            } else {
                if (t != sum/3) return false;
                break;
            }

        }
        for (int m = A.length - 1, t = 0; m >= 0; m--){
            if (t < sum/3) {
                t+=A[m];
                j = m;
            } else {
                if (t != sum/3) return false;
                break;
            }
        }
        System.out.println(i + "  " + j);
        return i > 0 && j < A.length - 1 && i < j;
    }
}
