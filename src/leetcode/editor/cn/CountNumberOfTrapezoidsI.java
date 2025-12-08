//给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点在笛卡尔平面上的坐标。 
//
// 水平梯形 是一种凸四边形，具有 至少一对 水平边（即平行于 x 轴的边）。两条直线平行当且仅当它们的斜率相同。 
//
// 返回可以从 points 中任意选择四个不同点组成的 水平梯形 数量。 
//
// 由于答案可能非常大，请返回结果对 10⁹ + 7 取余数后的值。 
//
// 
//
// 示例 1： 
//
// 
// 输入： points = [[1,0],[2,0],[3,0],[2,2],[3,2]] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 
//
// 有三种不同方式选择四个点组成一个水平梯形： 
//
// 
// 使用点 [1,0]、[2,0]、[3,2] 和 [2,2]。 
// 使用点 [2,0]、[3,0]、[3,2] 和 [2,2]。 
// 使用点 [1,0]、[3,0]、[3,2] 和 [2,2]。 
// 
//
// 示例 2： 
//
// 
// 输入： points = [[0,0],[1,0],[0,1],[2,1]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
//
// 只有一种方式可以组成一个水平梯形。 
//
// 
//
// 提示： 
//
// 
// 4 <= points.length <= 10⁵ 
// –10⁸ <= xi, yi <= 10⁸ 
// 所有点两两不同。 
// 
//
// Related Topics 几何 数组 哈希表 数学 👍 22 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfTrapezoidsI {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTrapezoidsI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int mod = 1000_000_007;
        public int countTrapezoids(int[][] points) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int[] p : points) {
                map.put(p[1], map.getOrDefault(p[1], 0) + 1);
            }

            long ans = 0, s = 0; // s是遍历过所有行的边数
            for(int v : map.values()) {
                long k = (long)v * (v - 1) / 2;
                ans = (ans + s * k) % mod;
                s += k;
            }
            return (int)ans % mod;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
