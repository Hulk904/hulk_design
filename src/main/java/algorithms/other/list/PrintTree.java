package algorithms.other.list;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyuan on 2021/2/28.
 * 655. 输出二叉树
 *
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：

 行数 m 应当等于给定二叉树的高度。
 列数 n 应当总是奇数。
 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 每个未使用的空间应包含一个空的字符串""。
 使用相同的规则输出子树。

 */
public class PrintTree {

    List<List<String>> ans = new ArrayList();

    /**
     计算出高和宽
     */
    int[] dfs(TreeNode root){
        if (root == null) return new int[]{0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        return new int[] {Math.max(l[0], r[0]) + 1, Math.max(l[1], r[1])*2 + 1};
    }

    /**
     * 添充数据
     * @param root
     * @param h 高度
     * @param l 左边界
     * @param r 右边界
     */
    void fill (TreeNode root ,int h ,int l, int r){
        if (null == root) return;
        int mid = (l + r)/2;
        ans.get(h).set(mid, root.val + "");
        fill(root.left, h + 1, l , mid - 1);
        fill(root.right, h + 1, mid + 1, r);
    }

    public List<List<String>> printTree(TreeNode root) {
        int[] t =dfs(root);
        //初始化列表
        for (int i = 0; i < t[0]; i ++){
            ans.add(new ArrayList());
            for (int j = 0; j < t[1]; j++){
                ans.get(i).add("");
            }
        }
        fill(root, 0, 0, t[1] - 1);
        return ans;
    }
}
