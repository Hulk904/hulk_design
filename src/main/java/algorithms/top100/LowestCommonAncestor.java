package algorithms.top100;

import algorithms.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by yangyuan on 2020/1/13.
 *
 */
public class LowestCommonAncestor {

    /**
     * 第一个公共祖先
     */
    private TreeNode target;


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        root.left = left;
//        TreeNode temp = new TreeNode(4);
//        left.right = temp;
//        TreeNode right = new TreeNode(2);
//        root.right = right;
        System.out.println(JSON.toJSONString(lowestCommonAncestor(root, left, root).val));
    }

    /**
     * 迭代实现
     * 需要记录遍历的结果 用hashMap来存放
     * 注意特殊用力p直接是q的parent 等场景。 p本身也会自身的parent
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();//起到遍历的效果
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        queue.add(root);
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right != null){
                queue.add(cur.right);
                parent.put(cur.right, cur);
            }
        }
        Set<TreeNode> parentSet = new HashSet<>();
        while (p != null){
            parentSet.add(p);
            p = parent.get(p);
        }
        while (q != null){
            if (parentSet.contains(q)){
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }


    /**
     * 递归实现
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRecurse(TreeNode root, TreeNode p, TreeNode q){
        recurse(root, p, q);
        return target;
    }

    /**
     * 递归实现 有没有找到 p 、q
     * @param cur
     * @param p
     * @param q
     * @return
     */
    public boolean recurse(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null){
            return false;
        }
        int left = recurse(cur.left, p, q) ? 1 : 0;
        int right = recurse(cur.right, p, q) ? 1 : 0;

        int mid = (cur == p || cur == q) ? 1 : 0 ;
        if (mid + left + right >= 2){//如果两个都找到了
            target = cur;
        }
        return left + right + mid >=1;
    }


    /**
     * 简洁的思路 覃超 视频里的
     * 思路： 在左树里面找是否存在p、q节点。在右子树是否存在pq节点
     *
     * 如果以root为根的子树中包含p和q，则返回他们的最近公共祖先
     * 如果只包含p则返回p
     * 如果只包含q则返回q
     * 如果都不包含则返回null
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorRecurse2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestorRecurse2(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecurse2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
