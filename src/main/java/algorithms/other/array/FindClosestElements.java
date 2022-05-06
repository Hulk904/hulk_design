package algorithms.other.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yangyuan on 2021/2/28.
 *
 * 658. 找到 K 个最接近的元素
 *
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。

 整数 a 比整数 b 更接近 x 需要满足：

 |a - x| < |b - x| 或者
 |a - x| == |b - x| 且 a < b

 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //双关键字排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b  : (Math.abs(a - x) > Math.abs(b - x) ? 1 : -1));
        for (int i:arr){
            queue.add(i);
        }
        Integer[] res = new Integer[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        Arrays.sort(res);
        return Arrays.asList(res);
    }

    //数组本身有序，所以可以用二分来做
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        //二分找到大于等于x的 第一个数
        while (l < r){
            int mid = (l + r) >> 1;
            if (arr[mid] >= x) r = mid;
            else l = mid + 1;
        }
        //有可能二分出出来的 r 不是合适的值，做个调整
        if (r > 0){
            int t = arr[r - 1], y = arr[r];
            if (Math.abs(arr[r - 1] - x) <= Math.abs(arr[r] - x))
                r--;
        }
        int i = r, j =r;
        for (int u = 0; u < k - 1; u++){
            if (i - 1 < 0) j++;
            else if (j + 1 >= arr.length) i--;
            else {
                int a = arr[i - 1], y = arr[j + 1];
                if (Math.abs(a - x) <= Math.abs(y - x)){
                    i --;
                } else {
                    j++;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int a = i; a <= j ;a++){
            res.add(arr[a]);
        }
        return res;
    }
}
