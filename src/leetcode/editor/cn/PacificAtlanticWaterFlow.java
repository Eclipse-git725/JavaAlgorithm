//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 770 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = heights.length;
            int m = heights[0].length;

            boolean[][] pac = new boolean[n][m];
            boolean[][] atlan = new boolean[n][m];

            // 从太平洋能到的点
            for(int i = 0; i < m; i ++ ) {
                dfs(0, i, pac, heights);
            }
            for(int i = 0; i < n; i ++ ) {
                dfs(i, 0, pac, heights);
            }
            // 从大西洋能到的点
            for(int i = 0; i < n; i ++ ) {
                dfs(i, m - 1, atlan, heights);
            }
            for(int i = 0; i < m; i ++ ) {
                dfs(n - 1, i, atlan, heights);
            }

            // 两者的交集为答案
            for(int i = 0; i < n; i ++ ) {
                for(int j = 0; j < m; j ++ ) {
                    if(pac[i][j] == true && atlan[i][j] == true) {
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
            return ans;
        }

        void dfs(int i, int j, boolean[][] st, int[][] h) {
            if(st[i][j]) return;
            st[i][j] = true;
            for(int d = 0; d < 4; d ++ ) {
                int x = i + dir[d][0];
                int y = j + dir[d][1];
                if(x >= 0 && x < h.length && y >= 0 && y < h[0].length && h[x][y] >= h[i][j]) {
                    dfs(x, y, st, h);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
