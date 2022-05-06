package algorithms.other.btree;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/12/5.
 * 1028. 从先序遍历还原二叉树
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。

 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

 如果节点只有一个子节点，那么保证该子节点为左子节点。

 给出遍历输出 S，还原树并返回其根节点 root。

  

 */
public class RecoverFromPreorder {
    List<int[]> nodes = new ArrayList();
    int k = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        for (int i = 0; i < traversal.length();){
            int dep = 0;
            while (traversal.charAt(i) == '-'){
                dep++;i++;
            }
            int val = 0;
            while (i < traversal.length() && traversal.charAt(i) != '-'){
                val = val*10 + traversal.charAt(i++) - '0';
            }
            nodes.add(new int[]{dep, val});
        }
        return dfs(0);
    }
    TreeNode dfs(int d){
        //根据下一节点深度跟当前节点深度大小 比较： 大的话就是子节点，小于或等于就是回溯了
        if (k == nodes.size()) return null;
        TreeNode root = new TreeNode(nodes.get(k)[1]);
        k++;
        if (k < nodes.size() && nodes.get(k)[0] > d){
            root.left = dfs(d + 1);
        }
        if ( k < nodes.size() && nodes.get(k)[0] > d){
            root.right = dfs(d + 1);
        }
        return root;
    }
}
