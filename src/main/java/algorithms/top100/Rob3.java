package algorithms.top100;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyuan on 2020/3/13.
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

 */
public class Rob3 {

    //备忘录加速 计算
    // leetcode上不使用map 1147ms 使用后3ms
    Map<TreeNode, Integer> map = new HashMap<>();

    /**
     * 回溯实现
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
             return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        //抢劫root
        int rob =  root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        //不抢劫root
        int notRob = rob(root.left) + rob(root.right);
        map.put(root, Math.max(rob, notRob));
        return Math.max(rob, notRob);
    }

    public int rob2(TreeNode root){
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     *  leetcode上这个方式最快
     * 0 不抢root
     * 1 抢root
     * @param root
     * @return
     */
    int[] dp(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //抢root时， 那么对于子节点 只能选择不抢
        int rob = root.val + left[0] + right[0];
        //不抢root时  对于子节点，可以抢也可以不抢(左右分开)  所以取最大利益
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRob, rob};
    }
}
