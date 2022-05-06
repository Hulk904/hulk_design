package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyuan on 2021/5/23.
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */
public class DistanceK {
    //图的遍历问题
    Map<TreeNode, List<TreeNode>> g = new HashMap();//存为邻接表
    List<Integer> res = new ArrayList();

    // 遍历生成邻接表数据
    void dfs1(TreeNode root){
        if (root.left != null){
            if (g.get(root) == null){
                g.put(root, new ArrayList());
            }
            g.get(root).add(root.left);
            if (g.get(root.left) == null) g.put(root.left, new ArrayList());
            g.get(root.left).add(root);
            dfs1(root.left);
        }
        if (root.right != null){
            if (g.get(root) == null){
                g.put(root, new ArrayList());
            }
            g.get(root).add(root.right);
            if (g.get(root.right) == null){
                g.put(root.right, new ArrayList());
            }
            g.get(root.right).add(root);
            dfs1(root.right);
        }
    }
    // father 父节点，避免往回走。  k 当前距离
    void dfs2(TreeNode root, TreeNode father, int k){
        if (k == 0) res.add(root.val);
        else {
            if (g.get(root) != null){
                for (TreeNode son:g.get(root)){//遍历子节点
                    if (son != father){
                        dfs2(son, root, k - 1);
                    }
                }
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs1(root);
        dfs2(target, null, k);
        return res;
    }
}
