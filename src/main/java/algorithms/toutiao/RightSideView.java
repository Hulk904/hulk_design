package algorithms.toutiao;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;
import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/2/2.
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

 示例:

 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:

 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---

 */
public class RightSideView {

    public static void main(String[] args) {
        Integer[] data = {1,2,3,null,5,null,4};
        TreeNode treeNode = TreeUtil.buildTree(data);
        System.out.println(JSON.toJSONString(rightSideView(treeNode)));
    }

    /**
     * 在每行最后添加毒节点。
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return Collections.EMPTY_LIST;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null && queue.isEmpty()){
                break;
            }
            if (queue.peek() == null){// 这个是试探的关键 提前做
                result.add(cur.val);
            }
            if (cur == null){
                queue.add(null);
                continue;
            }
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return result;
    }
}
