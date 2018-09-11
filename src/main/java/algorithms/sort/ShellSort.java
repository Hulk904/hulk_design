package algorithms.sort;

import java.util.Random;

/**
 * 基于插入排序，先部分有序，然后将跨度逐渐变为1，成为插入排序了 ，最后整体有序
 * Created by yangyuan on 2018/4/3.
 */
public class ShellSort extends SortTemplate{

    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = h*3 +1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }

    }

    public static void main(String[] args) {
        Integer[] list = new Integer[20];
        Random random = new Random(100);
        for(int i = 0; i < 20; i++){
            list[i] = random.nextInt(100);
        }
        new ShellSort().sort(list);
        SortTemplate.show(list);
    }
}
