//给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 
//[x, y] 的一个 唯一 建筑。 
//
// 如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。 
//
// 返回 被覆盖 的建筑数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]] 
// 
//
// 输出: 1 
//
// 解释: 
//
// 
// 只有建筑 [2,2] 被覆盖，因为它在每个方向上都至少存在一个建筑： 
// 
//
// 
// 上方 ([1,2]) 
// 下方 ([3,2]) 
// 左方 ([2,1]) 
// 右方 ([2,3]) 
// 
// 
// 因此，被覆盖的建筑数量是 1。 
//
//
// 示例 2： 
//
// 
//
// 
// 输入: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]] 
// 
//
// 输出: 0 
//
// 解释: 
//
// 
// 没有任何一个建筑在每个方向上都有至少一个建筑。 
// 
//
// 示例 3： 
//
// 
//
// 
// 输入: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]] 
// 
//
// 输出: 1 
//
// 解释: 
//
// 
// 只有建筑 [3,3] 被覆盖，因为它在每个方向上至少存在一个建筑： 
// 
//
// 
// 上方 ([1,3]) 
// 下方 ([5,3]) 
// 左方 ([3,2]) 
// 右方 ([3,5]) 
// 
// 
// 因此，被覆盖的建筑数量是 1。 
//
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= buildings.length <= 10⁵ 
// buildings[i] = [x, y] 
// 1 <= x, y <= n 
// buildings 中所有坐标均 唯一 。 
// 
//
// Related Topics 数组 哈希表 排序 👍 25 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountCoveredBuildings {
    public static void main(String[] args) {
        Solution solution = new CountCoveredBuildings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCoveredBuildings(int n, int[][] buildings) {
            // 哈希表维护每行每列的最大和最小值
            Map<Integer, int[]> row = new HashMap<>();
            Map<Integer, int[]> col = new HashMap<>();
            int ans = 0;
            for(int[] b : buildings) {
                int x = b[0], y = b[1];
                if(row.containsKey(x)) {
                    int minx = Math.min(row.get(x)[0], y);
                    int maxx = Math.max(row.get(x)[1], y);
                    row.put(x, new int[]{minx, maxx});
                }else {
                    row.put(x, new int[]{y, y});
                }
                if(col.containsKey(y)) {
                    int miny = Math.min(col.get(y)[0], x);
                    int maxy = Math.max(col.get(y)[1], x);
                    col.put(y, new int[]{miny, maxy});
                }else {
                    col.put(y, new int[]{x, x});
                }
            }
            for(int[] b : buildings) {
                int x = b[0], y = b[1];
                if (row.containsKey(x) && col.containsKey((y))) {
                    if (row.get(x)[0] < y && row.get(x)[1] > y && col.get(y)[0] < x && col.get(y)[1] > x) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
