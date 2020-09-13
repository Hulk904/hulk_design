package algorithms.other;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/15.
 *面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class GetLeastNumbers {



    /**
     * 快排的partition
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};
        int left = 0;
        int right  = arr.length - 1;
        int partition = partition(arr, left, right);
        for(;;){
            System.out.println(partition);
            if (partition < k - 1){
                left = partition + 1;
                partition = partition(arr, left, right);
            } else if (partition > k - 1){
                right = partition - 1;
                partition = partition(arr, left, right);
            } else {
                return Arrays.copyOf(arr, k);
            }
        }
    }
    int partition(int[] arr, int left, int right){
        int temp = arr[left];
        while (left < right){
            while (left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    /**
     * 基于计数排序  题目提示数据取值范围为 0 <= arr[i] <= 10000   【数据范围有限时直接计数排序就行了】
     * leetcode 执行效果比 快排还要快呢
     * 虽然也叫计数排序，但是跟 TopKFrequent 还是稍有不同的哦
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] count = new int[10001];
        for (int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }
        int[] res = new int[k];
        int t = 0;
        for (int i = 0; i < count.length; i++){
            while (count[i]-- > 0 && t < k){
                res[t++] = i;
            }
            if (t == k){
                break;
            }
        }
        return res;
    }
}
