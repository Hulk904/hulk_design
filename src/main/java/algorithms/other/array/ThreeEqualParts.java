package algorithms.other.array;

/**
 * Created by yangyuan on 2021/6/19.
 * 927. 三等分
 *
 * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。

 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：

 A[0], A[1], ..., A[i] 组成第一部分；
 A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
 A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 这三个部分所表示的二进制值相等。
 如果无法做到，就返回 [-1, -1]。
 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值

 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        //分界点是明确的
        int sum = 0;//1的个数
        for (int x:arr) sum += x;
        if (sum == 0) return new int[]{0, 2};
        if (sum%3 > 0) return new int[] {-1, -1};
        int avg = sum/3;
        int s[] = new int[]{1, avg, avg + 1, 2* avg, 2*avg + 1, 3*avg};
        int p[] = new int[6];
        int n = arr.length;
        for (int i = 0 ,j = 0, c = 0; i < n; i++){
            if (arr[i] == 0) continue;
            c++;
            while (j < 6 && s[j] == c) p[j++] = i;
        }
        int zero = n - 1 - p[5];//每个数后面0的个数
        if (p[4] - p[3] - 1 < zero || p[2] - p[1] - 1 < zero) return new int[]{-1, -1};
        if (!check(arr, p[0], p[1] + zero, p[2], p[3] + zero)) return new int[]{-1, -1};
        if (!check(arr, p[2], p[3] + zero, p[4], n - 1)) return new int [] {-1, -1};
        return new int[]{p[1] + zero, p[3] + zero + 1};
    }

    boolean check(int[] arr, int a, int b, int c, int d){
        for (int i = a, j = c; i <= b; i++, j++){
            if (arr[i] != arr[j]){
                return false;
            }
        }
        return true;
    }
}
