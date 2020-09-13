package algorithms.other;

/**
 * Created by yangyuan on 2020/4/12.
 * 1274. 矩形内船只的数目
 *
 * 在用笛卡尔坐标系表示的二维海平面上，有一些船。每一艘船都在一个整数点上，且每一个整数点最多只有 1 艘船。
 有一个函数 Sea.hasShips(topRight, bottomLeft) ，输入参数为右上角和左下角两个点的坐标，
 当且仅当这两个点所表示的矩形区域（包含边界）内至少有一艘船时，这个函数才返回 true ，否则返回 false 。
 给你矩形的右上角 topRight 和左下角 bottomLeft 的坐标，请你返回此矩形内船只的数目。题目保证矩形内 至多只有 10 艘船。
 调用函数 hasShips 超过400次 的提交将被判为 错误答案（Wrong Answer） 。同时，任何尝试绕过评测系统的行为都将被取消比赛资格

 */
public class CountShips {

    Sea sea;

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        this.sea = sea;
        return count(topRight, bottomLeft);
    }

    private int count(int[] topRight, int[] bottomLeft){
        if (!sea.hasShips(topRight, bottomLeft)){
            return 0;
        } else {
            if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
                return 1;
            }
        }
        int mx = bottomLeft[0] + (topRight[0] - bottomLeft[0])/2;
        int my = bottomLeft[1] + (topRight[1] - bottomLeft[1])/2;
        return count(new int[]{mx, my}, bottomLeft) +
                count(topRight, new int[]{ mx + 1, my + 1}) +
                count(new int[] {mx, topRight[1]}, new int[] {bottomLeft[0], my + 1}) +
                count(new int[] {topRight[0], my}, new int[] {mx + 1, bottomLeft[1]});

    }


    /**
     * 在此基础上有什么可以优化的吗？可以发现在查询接近尾声时，可能出现查询区域矩形一个轴向的长度已经为0，
     * 此时只需要二分另一个轴的长度即可，节约了调用API的次数。在此基础上稍加调整，
     * @param topRight
     * @param bottomLeft
     * @return
     */
    private int count2(int[] topRight, int[] bottomLeft){
        if (!sea.hasShips(topRight, bottomLeft)){
            return 0;
        } else {
            if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
                return 1;
            }
        }
        int mx = bottomLeft[0] + (topRight[0] - bottomLeft[0])/2;
        int my = bottomLeft[1] + (topRight[1] - bottomLeft[1])/2;
        int count = count2(new int[]{mx, my}, bottomLeft);
        //todo .... if ()
        return +
                count2(topRight, new int[]{ mx + 1, my + 1}) +
                count2(new int[] {mx, topRight[1]}, new int[] {bottomLeft[0], my + 1}) +
                count2(new int[] {topRight[0], my}, new int[] {mx + 1, bottomLeft[1]});

    }


}

class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft) {
        return false;
    }
}
