package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by yangyuan on 2020/1/17.
 * 给定一个二叉树，它的每个结点都存放着一个整数值。

 找出路径和等于给定数值的路径总数。

 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

 示例：

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 返回 3。和等于 8 的路径有:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3.  -3 -> 11

 */
public class PathSum {


    public static void main(String[] args) {
        Integer[] data = {1,-2,-3,1,3,-2,null,-1};
        //System.out.println(JSON.toJSONString(buildTree(data)));
        System.out.println(JSON.toJSONString(pathSum(TreeUtil.buildTree(data),-1)));
    }



    /**
     * 深度优先遍历 ，累加所有的值
     * @param root
     * @param sum
     * @return
     */
    public static  int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            result+=rootPathSumSuccess(curNode, sum);
            if (curNode.left != null){
                queue.add(curNode.left);
            }
            if (curNode.right != null){
                queue.add(curNode.right);
            }
        }
        return result;
    }

    /**
     * 计算以某个节点开始的总数， 这个方法的问题是
     * 如果已经存在了则不会再往下计算
     * 比如      1
     *          /
     *         -2
     *         /
     *        1
     *        /
     *      -1
     *
     * 要求和为 -1
     * 在 1，-2满足条件的情况下不会往下继续计算了。但是 1 ，-2， 1 ，-1 仍然满足条件呢。。。
     * @param root
     * @param sum
     * @return
     */
    public  static int rootPathSumError(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        if (root.val == sum){
            return 1;
        }
        return rootPathSumError(root.left, sum - root.val) +
                rootPathSumError(root.right, sum - root.val);
    }

    /**
     * 计算以某个节点开始的总数
     * @param root
     * @param sum
     * @return
     */
    public  static int rootPathSumSuccess(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.val == sum){
            res += 1;
        }
         res +=rootPathSumSuccess(root.left, sum - root.val) ;
          res += rootPathSumSuccess(root.right, sum - root.val);
        return  res;
    }

    //https://leetcode-cn.com/problems/path-sum-iii/solution/liang-chong-fang-fa-jian-dan-yi-dong-ban-ben-by-a3/

    /**
     * 回溯 利用hashmap剪枝
     * @param root
     * @param sum
     * @return
     */
    public  int pathSum2(TreeNode root, int sum){
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//别漏了
        return cal(root, map, sum, 0);
    }

    /**
     *
     * @param node
     * @param map
     * @param sum
     * @param pathSum 记录的是前序遍历中所有走过节点的和
     * @return
     */
    public int cal(TreeNode node, Map<Integer, Integer> map, int sum, int pathSum){
        if (node == null){
            return 0;
        }
        pathSum += node.val;
        int res = map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        int left = cal(node.left, map, sum, pathSum);
        int right = cal(node.right, map, sum, pathSum);
        map.put(pathSum, map.get(pathSum) - 1);//map全局变量， 最后需要回溯
        return res + left + right;
    }

    /**
     *
     */
    Map<Integer, Integer> map = new HashMap();

    private int target;

    private int res;

    public int pathSum4(TreeNode root, int sum) {
        this.target = sum;
        map.put(0, 1);
        trace(root, 0);
        return res;
    }

    private void trace(TreeNode node, int curSum){
        if (node == null) return;
        curSum += node.val;
        Integer exitTimes = map.getOrDefault(curSum - target, 0);
        if (exitTimes != 0){
            res+=exitTimes;//注意是累加 而不是 res++. 像  0，1，1  target = 1 这种情况
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        trace(node.left, curSum);
        trace(node.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }


}
