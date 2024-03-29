package algorithms.other;

import algorithms.TreeNode;
import algorithms.top100.TreeUtil;

import java.util.*;

/**
 * Created by yangyuan on 2020/2/24.
 * 652. 寻找重复的子树
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

 两棵树重复是指它们具有相同的结构以及相同的结点值。

 示例 1：

 1
 / \
 2   3
 /   / \
 4   2   4
    /
   4
 下面是两个重复的子树：

 2
 /
 4
 和

 4
 因此，你需要以列表的形式返回上述重复子树的根结点。

 子树：当前节点开始到叶子节点，不能只取中间的一截

 */
public class FindDuplicateSubtrees {

    private List<TreeNode> treeNodes = new ArrayList<>();

    private Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildTree(new Integer[]{1,2,3});
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(treeNode));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfsTime2(root);
        return treeNodes;
    }

    private String dfsTime2(TreeNode treeNode){
        if (treeNode == null){
            return "#";
        }
        String left = dfsTime2(treeNode.left);
        String right = dfsTime2(treeNode.right);
        String t = treeNode.val + "," + left + "," + right;
        if (map.containsKey(t)){
            if (map.get(t) == 1){
                treeNodes.add(treeNode);
            }
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
        return t;
    }


    /**
      通过先序遍历获取相关序列。
      如果标记了空节点的，那么通过先序遍历的序列是可以恢复树结构的。
     */
    private String dfs (TreeNode node){
        if (node == null){
            return "#";
        }
        String left = dfs(node.left);
        String right = dfs(node.right);
        String t = node.val + "," + left + "," + right;//要是前序遍历才行哦。。
        if (map.containsKey(t)){
            if (map.get(t) == 1) {
                treeNodes.add(node);
            }
            map.put(t, map.get(t) + 1);//重复的不用再计算
        } else {
            map.put(t, 1);
        }
        return t;
    }


    /**
     * 把子树映射为一个三元组
     * 这样使用的空间会小些，不像上面存放的是整个树序列化后的， 空间会比较大
     */

    Map<String, Integer> ids = new HashMap();//三元组 和id 映射

    int cnt = 0; //当前树id

    Map<Integer, Integer> hash = new HashMap();//每个id出现多少次

    List<TreeNode> res = new ArrayList();

    public List<TreeNode> findDuplicateSubtrees3(TreeNode root) {
        dfs3(root);
        return res;
    }

    private int dfs3(TreeNode root){//返回id
        if (root == null) return 0;
        int left = dfs3(root.left);
        int right = dfs3(root.right);
        String key = root.val + "," + left + "," + right;
        if (ids.get(key) == null) {//当前key 未出现过
            ids.put(key, ++cnt);//分配一个唯一值
        }
        int id = ids.get(key);
        hash.put(id, hash.getOrDefault(id, 0) + 1);
        if (hash.get(id) == 2){
            res.add(root);
        }
        return id;
    }
}
