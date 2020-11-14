package algorithms.other;

import java.util.DoubleSummaryStatistics;
import java.util.Random;

/**
 * Created by yangyuan on 2020/11/7.
 *
 *
 */
public class RandPoint {

    double radius;

    double x;

    double y;

    public  RandPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    /**
     *  等概率产生矩形
     *  然后重新生成圆外的点
     * @return
     */
    public double[] randPoint() {
        Random random = new Random();
        double a = random.nextDouble()*2 - 1;
        double b = random.nextDouble()* 2 - 1;
        if (a*a + b* b > 1) return randPoint();
        return new double[]{x + radius*a, y + radius*b};
    }

}
