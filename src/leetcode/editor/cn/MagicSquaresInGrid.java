//3 x 3 的幻方是一个填充有 从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。 
//
// 给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？ 
//
// 注意：虽然幻方只能包含 1 到 9 的数字，但 grid 可以包含最多15的数字。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
//输出: 1
//解释: 
//下面的子矩阵是一个 3 x 3 的幻方：
//
//而这一个不是：
//
//总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[8]]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// row == grid.length 
// col == grid[i].length 
// 1 <= row, col <= 10 
// 0 <= grid[i][j] <= 15 
// 
//
// Related Topics 数组 哈希表 数学 矩阵 👍 84 👎 0


package leetcode.editor.cn;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        Solution solution = new MagicSquaresInGrid().new Solution();
        solution.numMagicSquaresInside(new int[][]{{3,10,2,3,4}, {4,5,6,8,1}, {8,8,1,6,8}, {1,3,5,7,1}, {9,4,9,2,9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for(int i = 0; i <= m - 3; i ++ ) {
                for(int j = 0; j <= n - 3; j ++ ) {
                    boolean flag = true;
                    int sum1 = 0, sum2 = 0;
                    if(grid[i + 1][j + 1] != 5) {
                        flag = false;
                    }
                    for(int k = 0; k < 3; k ++ ) {
                        int rsum = grid[i + k][j + 1] + grid[i + k][j + 2] + grid[i + k][j];
                        int csum = grid[i][j + k] + grid[i + 1][j + k] + grid[i + 2][j + k];
                        if(rsum != 15 || csum != 15) {
                            flag = false;
                            break;
                        }
                    }
                    int mul = 1;
                    for(int k = 0; k < 9; k ++ ) {
                        int a = k / 3, b = k % 3;
                        mul *= grid[i + a][j + b];
                        if(grid[i + a][j + b] <= 0 || grid[i + a][j + b] >= 10) {
                            flag = false;
                        }
                    }
                    if(mul != 362880) {
                        flag = false;
                    }
                    // 对角线判断
                    sum1 = 0;
                    sum2 = 0;
                    for(int k = 0; k < 3; k ++ ) {
                        sum1 += grid[i + k][j + k];
                        sum2 += grid[i + k][j + 2 - k];
                    }
                    if(sum1 != sum2) {
                        flag = false;
                    }
                    if(flag) {
                        ans ++;
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
