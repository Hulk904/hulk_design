package algorithms.sort;


import java.util.Random;

/**
 * Created by yangyuan on 2018/3/31.
 */
public class SelectionSort extends SortTemplate{

    public void sort(Comparable[] a) {
        int length = a.length;
        for(int i = 0; i < length; i++){
            int min = i;
            for(int j = i; j < length; j ++){
                if(less(a[min], a[j])){//attention

                }else {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] list = new Integer[20];
        Random random = new Random(100);
        for(int i = 0; i < 20; i++){
            list[i] = random.nextInt(100);
        }
        new SelectionSort().sort(list);
        SortTemplate.show(list);
    }
}
