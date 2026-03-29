//给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。 
//
// 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整
//数的乘积。 
//
// 返回 最大非负积 对 10⁹ + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。 
//
// 注意，取余是在得到最大积之后执行的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
//输出：-1
//解释：从 (0, 0) 到 (2, 2) 的路径中无法得到非负积，所以返回 -1 。 
//
// 示例 2： 
// 
// 
//输入：grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
//输出：8
//解释：最大非负积对应的路径如图所示 (1 * 1 * -2 * -4 * 1 = 8)
// 
//
// 示例 3： 
// 
// 
//输入：grid = [[1,3],[0,-4]]
//输出：0
//解释：最大非负积对应的路径如图所示 (1 * 0 * -4 = 0)
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 15 
// -4 <= grid[i][j] <= 4 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 92 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumNonNegativeProductInAMatrix {
    public static void main(String[] args) {
        Solution solution = new MaximumNonNegativeProductInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProductPath(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            // dp[i][j][0] 表示到达 (i, j) 的 最大乘积
            // dp[i][j][1] 表示到达 (i, j) 的 最小乘积
            long[][][] dp = new long[m][n][2];

            dp[0][0][0] = grid[0][0];
            dp[0][0][1] = grid[0][0];

            // 第一行
            for(int j = 1; j < n; j ++ ) {
                dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
                dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
            }

            // 第一列
            for(int i = 1; i < m; i ++ ) {
                dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
                dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
            }

            for(int i = 1; i < m; i ++ ) {
                for(int j = 1; j < n; j ++ ) {
                    if(grid[i][j] < 0) {
                        dp[i][j][0] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]) * grid[i][j];
                        dp[i][j][1] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) * grid[i][j];
                    }else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) * grid[i][j];
                        dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]) * grid[i][j];
                    }
                }
            }

            if(dp[m - 1][n - 1][0] < 0) {
                return -1;
            }
            return (int)(dp[m - 1][n - 1][0] % 1_000_000_007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
