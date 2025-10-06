//在一个 n x n 的整数矩阵 grid 中，每一个方格的值 grid[i][j] 表示位置 (i, j) 的平台高度。 
//
// 当开始下雨时，在时间为 t 时，水池中的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间
//移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 
//
// 你从坐标方格的左上平台 (0，0) 出发。返回 你到达坐标方格的右下平台 (n-1, n-1) 所需的最少时间 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: grid = [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
// 
//
// 示例 2: 
//
// 
//
// 
//输入: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,
//9,8,7,6]]
//输出: 16
//解释: 最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
// 
//
// 
//
// 提示: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] < n² 
// grid[i][j] 中每个值 均无重复 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 344 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static void main(String[] args) {
        Solution solution = new SwimInRisingWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int swimInWater(int[][] grid) {
            // 找从起点到终点的路径上的最大值最小
            int n = grid.length;
            int[][] d = new int[n][n];
            for(int[] row : d) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            pq.add(new int[]{grid[0][0], 0, 0});
            d[0][0] = grid[0][0];

            while(true) {
                int[] t = pq.poll();
                int dis = t[0], i = t[1], j = t[2];
                if(i == n - 1 && j == n - 1) {
                    return dis;
                }

                if(dis > d[i][j]) {
                    continue;
                }

                for(int k = 0; k < 4; k ++ ) {
                    int x = dir[k][0] + i, y = dir[k][1] + j;
                    if(x >= 0 && x < n && y >= 0 && y < n) {
                        int newd = Math.max(dis, grid[x][y]);
                        if(newd < d[x][y]) {
                            d[x][y] = newd;
                            pq.add(new int[]{newd, x, y});
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
