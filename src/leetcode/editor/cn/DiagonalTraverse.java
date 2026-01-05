//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 550 👎 0

  
package leetcode.editor.cn;
public class DiagonalTraverse{
  public static void main(String[] args) {
       Solution solution = new DiagonalTraverse().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int cnt = 0;
        for(int k = 0; k < m + n - 1; k ++ ) {
            int maxi = Math.min(m - 1, k);
            int mini = Math.max(0, k - n + 1);
            if(k % 2 == 1) {
                for(int i = mini; i <= maxi; i ++ ) {
                    ans[cnt ++ ] = mat[i][k - i];
                }
            }else {
                for(int i = maxi; i >= mini; i -- ) {
                    ans[cnt ++ ] = mat[i][k - i];
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
