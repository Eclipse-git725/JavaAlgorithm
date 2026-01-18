//一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。幻方中的整数 不需要互不相同 。显然，
//每个 1 x 1 的方格都是一个幻方。 
//
// 给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）。 
//
// 
//
// 示例 1： 
// 输入：grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
//输出：3
//解释：最大幻方尺寸为 3 。
//每一行，每一列以及两条对角线的和都等于 12 。
//- 每一行的和：5+1+6 = 5+4+3 = 2+7+3 = 12
//- 每一列的和：5+5+2 = 1+4+7 = 6+3+3 = 12
//- 对角线的和：5+4+3 = 6+4+2 = 12
// 
//
// 示例 2： 
// 输入：grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j] <= 10⁶ 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 33 👎 0


package leetcode.editor.cn;

public class LargestMagicSquare {
    public static void main(String[] args) {
        Solution solution = new LargestMagicSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestMagicSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] rowSum = new int[m][n + 1]; // rowSum[i][j] 第i行前j个元素的前缀和
            int[][] colSum = new int[m + 1][n];
            int[][] diagSum = new int[m + 1][n + 1]; // diagSum[i+1][j+1] 从(0,0)到(i,j)的前缀和
            int[][] antiSum = new int[m + 1][n + 1]; // 反对角线前缀和

            // 计算四个前缀和
            for(int i = 0; i < m; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    int x = grid[i][j];
                    rowSum[i][j + 1] = rowSum[i][j] + x;
                    colSum[i + 1][j] = colSum[i][j] + x;
                    diagSum[i + 1][j + 1] = diagSum[i][j] + x;
                    antiSum[i + 1][j] = antiSum[i][j + 1] + x;
                }
            }

            for(int k = Math.min(m, n); k > 0; k -- ) {
                for(int i = k; i <= m; i ++ ) {
                    for(int j = k; j <= n; j ++ ) {
                        int sum = diagSum[i][j] - diagSum[i - k][j - k];
                        if(antiSum[i][j - k] - antiSum[i - k][j] != sum) {
                            continue;
                        }

                        // 检查每行的和是不是sum
                        boolean flag1 = true, flag2 = true;
                        for(int r = i - k; r < i; r ++ ) {
                            if(rowSum[r][j] - rowSum[r][j - k] != sum) {
                                flag1 = false;
                                break;
                            }
                        }
                        if(!flag1) {
                            continue;
                        }

                        // 检查每列的和是不是sum
                        for(int c = j - k; c < j; c ++ ) {
                            if(colSum[i][c] - colSum[i - k][c] != sum) {
                                flag2 = false;
                                break;
                            }
                        }
                        if(!flag2) {
                            continue;
                        }
                        return k;
                    }
                }

            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
