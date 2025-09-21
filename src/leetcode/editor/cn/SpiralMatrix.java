//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1991 👎 0


package leetcode.editor.cn;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            List<Integer> ans = new ArrayList<>();
            int x = 0, y = 0, d = 0;
            for(int i = 0; i < m * n; i ++ ) {
                ans.add(matrix[x][y]);
                matrix[x][y] = Integer.MAX_VALUE;
                int x1 = x + dir[d][0], y1 = y + dir[d][1];
                if(x1 >= m || x1 < 0 || y1 >= n || y1 < 0 || matrix[x1][y1] == Integer.MAX_VALUE) {
                    d = (d + 1) % 4;
                }
                x += dir[d][0];
                y += dir[d][1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
