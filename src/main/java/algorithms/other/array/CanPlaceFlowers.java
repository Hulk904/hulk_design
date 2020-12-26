package algorithms.other.array;

/**
 * Created by yangyuan on 2020/12/12.
 * 605. 种花问题
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False

 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++){
            if (flowerbed[i] > 0) continue;// 双指针计算连续0的个数
            int j = i;
            while (j < flowerbed.length && flowerbed[j] == 0) j++;
            int k = j - i - 1;
            if (i == 0) k++;// 是左边界
            if (j == flowerbed.length) k++;// 是右边界
            count += k/2;
            if (count >= n) return true;
            i = j;
        }
        return  false;
    }
}
