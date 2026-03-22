//给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的子矩阵数量： 
//
// 
// 包含 grid[0][0] 
// 'X' 和 'Y' 的频数相等。 
// 至少包含一个 'X'。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [["X","Y","."],["Y",".","."]] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入： grid = [["X","X"],["X","Y"]] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 不存在满足 'X' 和 'Y' 频数相等的子矩阵。 
//
// 示例 3： 
//
// 
// 输入： grid = [[".","."],[".","."]] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 不存在满足至少包含一个 'X' 的子矩阵。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 1000 
// grid[i][j] 可能是 'X'、'Y' 或 '.'. 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 15 👎 0


package leetcode.editor.cn;

public class CountSubmatricesWithEqualFrequencyOfXAndY {
    public static void main(String[] args) {
        Solution solution = new CountSubmatricesWithEqualFrequencyOfXAndY().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] cntX = new int[m + 1][n + 1];
            int[][] cntY = new int[m + 1][n + 1];
            int ans = 0;
            for(int i = 0; i < m; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    if(grid[i][j] == 'X') {
                        cntX[i + 1][j + 1] = cntX[i][j + 1] + cntX[i + 1][j] - cntX[i][j] + 1;
                        cntY[i + 1][j + 1] = cntY[i][j + 1] + cntY[i + 1][j] - cntY[i][j];
                    }else if(grid[i][j] == 'Y') {
                        cntY[i + 1][j + 1] = cntY[i][j + 1] + cntY[i + 1][j] - cntY[i][j] + 1;
                        cntX[i + 1][j + 1] = cntX[i][j + 1] + cntX[i + 1][j] - cntX[i][j];
                    }else {
                        cntX[i + 1][j + 1] = cntX[i][j + 1] + cntX[i + 1][j] - cntX[i][j];
                        cntY[i + 1][j + 1] = cntY[i][j + 1] + cntY[i + 1][j] - cntY[i][j];
                    }
                    if(cntY[i + 1][j + 1] == cntX[i + 1][j + 1] && cntY[i + 1][j + 1] > 0) {
                        ans ++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
