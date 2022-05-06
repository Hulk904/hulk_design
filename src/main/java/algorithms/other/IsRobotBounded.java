package algorithms.other;

/**
 * Created by yangyuan on 2021/12/13.
 * 1041. 困于环中的机器人
 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：

 "G"：直走 1 个单位
 "L"：左转 90 度
 "R"：右转 90 度
 机器人按顺序执行指令 instructions，并一直重复它们。

 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。

 */
public class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, d = 0;//d表示方向  0 表示向上
        int[] dx = new int[]{-1, 0,1,0}, dy = {0, 1, 0, -1};//顺序
        for (char c:instructions.toCharArray()){
            if (c == 'G') {// 当前方向走一格
                x+=dx[d];
                y+=dy[d];
            } else if (c == 'L'){
                d = (d + 3)%4;//左转
            } else {
                d = (d + 1)%4;//右转
            }
        }
        return (x == 0 && y == 0) || d != 0;//在远点或者方向不同
    }
}
