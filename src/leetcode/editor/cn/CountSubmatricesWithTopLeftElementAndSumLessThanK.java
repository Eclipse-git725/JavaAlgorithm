//给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。 
//
// 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[7,6,3],[6,6,1]], k = 18
//输出：4
//解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。 
//
// 示例 2： 
// 
// 
//输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
//输出：6
//解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= n, m <= 1000 
// 0 <= grid[i][j] <= 1000 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 16 👎 0

  
package leetcode.editor.cn;
public class CountSubmatricesWithTopLeftElementAndSumLessThanK{
  public static void main(String[] args) {
       Solution solution = new CountSubmatricesWithTopLeftElementAndSumLessThanK().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];

        int ans = 0;
        for(int i = 0; i < m; i ++ ) {
            for(int j = 0; j < n; j ++ ) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grid[i][j];
                if(sum[i + 1][j + 1] <= k) {
                    ans ++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
