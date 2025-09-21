//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
// 
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 919 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            // dp[i][j] 表示以(i, j)结尾的最长递增路径长度
            int[][] dp = new int[m][n];
            int[][] indeg = new int[m][n];

            for(int i = 0; i < m; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    for(int d = 0; d < 4; d ++ ) {
                        int x = i + dir[d][0], y = j + dir[d][1];
                        if(x < 0 || x >= m || y < 0 || y >= n) continue;
                        if(matrix[x][y] > matrix[i][j]) {
                            indeg[x][y] ++;
                        }
                    }
                    dp[i][j] = 1;
                }
            }
            Queue<int[]> q = new ArrayDeque<>();
            for(int i = 0; i < m; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    if(indeg[i][j] == 0) {
                        q.add(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            while(!q.isEmpty()) {
                for(int i = 0; i < q.size(); i ++ ) {
                    int[] t = q.poll();
                    for(int d = 0; d < 4; d ++ ) {
                        int x = t[0] + dir[d][0], y = t[1] + dir[d][1];
                        if(x < 0 || x >= m || y < 0 || y >= n) continue;
                        if(matrix[x][y] < matrix[t[0]][t[1]]) {
                            dp[t[0]][t[1]] = Math.max(dp[t[0]][t[1]], dp[x][y] + 1);
                        }else if(matrix[x][y] > matrix[t[0]][t[1]]) {
                            indeg[x][y] --;
                            if(indeg[x][y] == 0) {
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                    ans = Math.max(ans, dp[t[0]][t[1]]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
