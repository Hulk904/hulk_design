package algorithms.sort;

/**
 * Created by yangyuan on 2019/8/24.
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] a = new int[]{3,1,34,34,43,6,78,-1};
        quickSortTimes2(a, 0, a.length - 1);
        for(int i:a){
            System.out.println(i);
        }

    }
    static void quickSortTimes2(int[] array, int left, int right){
        if (left >= right) return;
        int pirot = partition(array, left, right);
        quickSortTimes2(array, left, pirot - 1);
        quickSortTimes2(array, pirot + 1, right);
    }

    static int partition(int[] array, int left, int right){
        int pirot = array[left];
        while (left < right){
            while (left < right && array[right] >= pirot){
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pirot){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pirot;
        return left;
    }


    private static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int pirot = pirot(array, left ,right);
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
