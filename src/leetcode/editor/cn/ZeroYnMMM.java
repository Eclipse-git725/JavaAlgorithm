//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 84 题相同： https://leetcode.cn/problems/largest-rectangle-in-histogram/
// 
//
// Related Topics 栈 数组 单调栈 👍 129 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left, -1);
            Arrays.fill(right, n);
            Deque<Integer> st = new ArrayDeque<>();
            // 右边第一个小于height[i]的位置
            for(int i = n - 1; i >= 0; i -- ) {
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if(!st.isEmpty()) {
                    right[i] = st.peek();
                }
                st.push(i);
            }
            st.clear();

            // 左边第一个小于height[i]的位置
            for(int i = 0; i < n; i ++ ) {
                while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if(!st.isEmpty()) {
                    left[i] = st.peek();
                }
                st.push(i);
            }
            int ans = 0;
            for(int i = 0; i < n; i ++ ) {
                ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
