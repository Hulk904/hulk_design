package algorithms.sort;

import java.util.Arrays;

/**
 * Created by yangyuan on 2020/4/14.
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr = {};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        //构建大顶堆
        for (int i = arr.length/2 -1; i >= 0; i--){
            //从第一个非叶子节点从下往上，从右至左调整结构
            down(arr, i, arr.length);
        }
        //调整堆结构 + 交换堆顶元素与末尾元素
        for(int i = arr.length - 1; i > 0; i--){
            swap(arr, 0 , i);//把最大元素放到最后，
            down(arr, 0 , i);//然后下沉顶元素
        }
    }

    /**
     * 调整大顶堆 （仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i 下沉的元素坐标
     * @param length 最大边界（不包含）
     */
    public static void down(int[] arr, int i ,int length){
        int temp = arr[i];//先取出当前元素i  下沉的元素
        //从i节点的左子节点开始，也就是2i + 1处, k = 2*k + 1，下次处理他的左子节点
        for (int k = i*2 + 1; k < length; k = k*2 + 1){
            if (k + 1 < length && arr[k] < arr[k + 1]){//如果左子节点小于右子节点，k指向右子节点
                k++;
            }
            if (arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）不要写成  arr[k] > arr[i] 了
                arr[i] = arr[k];
                i = k;
            } else {
                break;//可以及时退出  没有这个break也行
            }
        }
        arr[i] = temp;//将temp值放到最终的位置,i 记录对应的索引
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
