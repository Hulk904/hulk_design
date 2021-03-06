package algorithms.other;

/**
 * Created by yangyuan on 2020/4/22.
 * 365. 水壶问题
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {

        if (z > x + y) return false;
        return z == 0 || (z % gcd(x,y) == 0);
    }
    //求最大公约数模版
    int gcd (int a, int b){
        return b > 0 ? gcd (b, a % b) : a;
    }
}
