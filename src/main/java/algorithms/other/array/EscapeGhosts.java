package algorithms.other.array;

/**
 * Created by yangyuan on 2021/4/18.
 * 789. 逃脱阻碍者
 *
 * 你在进行一个简化版的吃豆人游戏。你从 [0, 0] 点开始出发，你的目的地是 target = [xtarget, ytarget] 。地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发。所有输入均为 整数坐标 。

 每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。当然，也可以选择 不动 。所有动作 同时 发生。

 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。

 只有在你有可能成功逃脱时，输出 true ；否则，输出 false

 */
public class EscapeGhosts {

    int dist (int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        //只需判断是否有鬼魂到终点的距离小于人到终点的距离
        for (int [] g:ghosts){
            if (dist(g[0], g[1], target[0], target[1]) <= Math.abs(target[0]) + Math.abs(target[1]))
                return false;
        }
        return true;
    }
}
