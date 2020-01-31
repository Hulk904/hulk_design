package algorithms.sort;

import com.alibaba.fastjson.JSON;

/**
 * Created by yangyuan on 2020/1/9.
 * 归并排序 递归实现
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] data = {43,23,6,12334,15,8,754,754,7,-1};
        mergeSort(data, 0 , data.length - 1);
        System.out.println(JSON.toJSONString(data));

    }

    private static void mergeSort(int[] data, int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private static void merge(int[] data, int left, int mid, int right){
        int first = left;
        int second = mid + 1;
        int[] temp = new int[data.length];//需要n的空间
        //int t = 0;  //注意1   起始点 是left而不是 0  写错了
        int t = left;
        while (first <= mid && second <= right){
            if (data[first] < data[second]){
                temp[t++] = data[first++];
            } else {
                temp[t++] = data[second++];
            }
        }
//        if (first <= mid){
//            while (t < data.length){ //注意 同上面一样 数组的又边界变为了right而不是 data.length
//                temp[t++] = data[second++];
//            }
//        } else {
//            while (t < data.length){
//                temp[t++] = data[first++];
//            }
//        }
        while (first <= mid) temp[t++] = data[first++];
        while (second <= right) temp[t++] = data[second++];//对于临界值的处理，是不是要包含进去  <=  还是 <
        //for (int i = 0; i < data.length; i++){
        for (int i = left; i <= right; i++){
            data[i] = temp[i];
        }
    }

}
