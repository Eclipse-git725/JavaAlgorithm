//给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。 
//
// 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作： 
//
//
// 
// 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足
// row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。 
// 
//
// 返回执行完所有操作后得到的矩阵 mat 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
//输出：[[1,1,0],[1,2,1],[0,1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
//- 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。 
//- 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 2, queries = [[0,0,1,1]]
//输出：[[1,1],[1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。 
//- 第一个操作：将矩阵中的每个元素加 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= queries.length <= 10⁴ 
// 0 <= row1i <= row2i < n 
// 0 <= col1i <= col2i < n 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 75 👎 0


package leetcode.editor.cn;

public class IncrementSubmatricesByOne {
    public static void main(String[] args) {
        Solution solution = new IncrementSubmatricesByOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] diff = new int[n + 2][n + 2];
            for(int[] query : queries) {
                int i1 = query[0], j1 = query[1], i2 = query[2], j2 = query[3];
                diff[i1 + 1][j1 + 1] ++;
                diff[i1 + 1][j2 + 2] --;
                diff[i2 + 2][j1 + 1] --;
                diff[i2 + 2][j2 + 2] ++; // 差分多减掉了一块
            }
            int[][] sum = new int[n + 1][n + 1];
            int[][] ans = new int[n][n];
            for(int i = 1; i <= n; i ++ ) {
                for(int j = 1; j <= n; j ++ ) {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + diff[i][j];
                    ans[i - 1][j - 1] = sum[i][j];
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
