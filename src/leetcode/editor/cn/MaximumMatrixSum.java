//给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ： 
//
// 
// 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。 
// 
//
// 如果两个元素有 公共边 ，那么它们就是 相邻 的。 
//
// 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。 
//
// 
//
// 示例 1： 
// 输入：matrix = [[1,-1],[-1,1]]
//输出：4
//解释：我们可以执行以下操作使和等于 4 ：
//- 将第一行的 2 个元素乘以 -1 。
//- 将第一列的 2 个元素乘以 -1 。
// 
//
// 示例 2： 
// 输入：matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
//输出：16
//解释：我们可以执行以下操作使和等于 16 ：
//- 将第二行的最后 2 个元素乘以 -1 。
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 2 <= n <= 250 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 矩阵 👍 45 👎 0


package leetcode.editor.cn;

public class MaximumMatrixSum {
    public static void main(String[] args) {
        Solution solution = new MaximumMatrixSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int n = matrix.length;
            int minv = Integer.MAX_VALUE;
            long ans = 0;
            int cnt = 0;
            int cnt0 = 0;
            for(int i = 0; i < n; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    if(matrix[i][j] < 0) {
                        cnt ++;
                        ans += matrix[i][j] * (-1);
                    }else if(matrix[i][j] > 0) {
                        ans += matrix[i][j];
                    }else {
                        cnt0 ++;
                    }
                    minv =Math.min(minv, Math.abs(matrix[i][j]));
                }
            }
            if(cnt % 2 == 0) {
                return ans;
            }
            if(cnt0 != 0) {
                return ans;
            }
            return ans - 2 * minv;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
