package algorithms.other.array;

/**
 * Created by yangyuan on 2021/12/27.
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

 注意：请不要在超过该数组长度的位置写入元素。

 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0, cnt = 0; i < n; i++){
            if (arr[i] > 0) cnt++;
            else cnt += 2;
            if (cnt >= n){
                boolean flag = false;
                if (cnt == n + 1) flag = true;//最后一个元素是0 且要超会范围
                for (int j = cnt - 1; i >= 0; i--){
                    if (arr[i] > 0) arr[j--] = arr[i];
                    else {
                        if (flag){
                            j--;//
                            arr[j--] = 0;
                            flag = false;
                        } else {
                            arr[j--] = 0;
                            arr[j--] = 0;
                        }
                    }
                }
                break;
            }
        }
    }
}
