package algorithms.other.array;

import java.util.Stack;

/**
 * Created by yangyuan on 2021/3/21.
 * 735. 行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的行星。

 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
 每一颗行星以相同的速度移动。

 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
 两颗移动方向相同的行星，永远不会发生碰撞。



 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack();
        for (int x:asteroids){
            if (x > 0) res.push(x);
            else {
                while (res.size() > 0 && res.peek() > 0 && res.peek() < -x) res.pop();//小于  消失
                if (res.size() > 0 && res.peek() == -x) res.pop(); // 两个相同质量， 都消失
                else if (res.isEmpty() || res.peek() < 0) res.push(x);//保留
            }
        }
        int[] ans = new int[res.size()];
        for (int i = res.size() - 1; i>= 0; i--){
            ans[i] = res.pop();
        }
        return ans;
    }
}
