package algorithms.other.btree;

/**
 * Created by yangyuan on 2020/10/24.
 * 427. 建立四叉树

 */
public class Construct {

    int[][] s;


    public Node construct(int[][] grid) {
        int n = grid.length;
        s = new int [n + 1][n + 1];
        //二维前缀和  便于快速判断 元素和是不是全0还是全1
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        return dfs(1, 1, n, n);
    }
    Node dfs (int x1, int y1, int x2, int y2){
        int n = x2 - x1 + 1;
        int sum = s[x2][y2] - s[x2][y1- 1] - s[x1 - 1][y2] + s[x1 - 1][y1 -1];//区间和
        if (sum == 0) return new Node( false, true);
        if (sum == n*n) return new Node(true, true);
        Node node = new Node(false, false);
        int m = n/2;
        node.topLeft = dfs(x1, y1, x1 + m - 1, y1 + m - 1);
        node.topRight = dfs(x1, y1 + m, x1 + m - 1, y2);
        node.bottomLeft = dfs(x1 + m, y1, x2, y1 + m - 1);
        node.bottomRight = dfs(x1 + m, y1 + m, x2, y2);
        return node;

    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
}
