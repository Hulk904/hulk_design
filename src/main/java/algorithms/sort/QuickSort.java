package algorithms.sort;

/**
 * Created by yangyuan on 2019/8/24.
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] a = new int[]{3,1,34,13,43,6,78,-1};
        quickSort(a, 0, a.length - 1);
        for(int i:a){
            System.out.println(i);
        }

    }

    private static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int pirot = pirot(array, left , array.length - 1);
        quickSort(array, left, pirot - 1);
        quickSort(array, pirot + 1, right);
    }

    private static int pirot(int[]array, int left, int right){
        int pirotKey = array[left];
        while (left < right){
            while (left < right && array[right] >= pirotKey){
                right --;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pirotKey){
                left ++;
            }
            array[right] = array[left];
        }
        array[left] = pirotKey;
        return left;
    }

}
