//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= rows, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1786 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 把第84题的方法执行m次，m是行数
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int ans = 0;
            int[] h = new int[n];
            for(int i = 0; i < m; i ++ ) {
                for(int j = 0; j < n; j ++ ) {
                    if(matrix[i][j] == '0') {
                        h[j] = 0;
                    }else {
                        h[j] ++;
                    }
                }
                ans = Math.max(ans, largestRectangleArea(h));
            }
            return ans;
        }
        // 84.柱状图中最大的矩形
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = st.peek();
                }
                st.push(i);
            }

            st.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    right[i] = n;
                } else {
                    right[i] = st.peek();
                }
                st.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
