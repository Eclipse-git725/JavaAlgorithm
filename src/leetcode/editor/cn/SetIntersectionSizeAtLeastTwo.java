//给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数
//，包括 starti 和 endi 。 
//
// 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。 
//
// 
// 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包
//含集合 的定义。 
// 
//
// 返回包含集合可能的最小大小。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[3,7],[8,9]]
//输出：5
//解释：nums = [2, 3, 4, 8, 9].
//可以证明不存在元素数量为 4 的包含集合。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
//输出：3
//解释：nums = [2, 3, 4].
//可以证明不存在元素数量为 2 的包含集合。 
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
//输出：5
//解释：nums = [1, 2, 3, 4, 5].
//可以证明不存在元素数量为 4 的包含集合。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 3000 
// intervals[i].length == 2 
// 0 <= starti < endi <= 10⁸ 
// 
//
// Related Topics 贪心 数组 排序 👍 209 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        Solution solution = new SetIntersectionSizeAtLeastTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            // 右端点从小到大排序，右端点相同的左端点从大到小排序
            Arrays.sort(intervals, (int[] a, int[] b) -> {
                if(a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });
            int x = -1, y = -1; // 当前已经处理的区间中选择的第一个点和第二个点
            int ans = 0;
            for(int[] interval : intervals) {
                int a = interval[0], b = interval[1];
                if(x < a && a <= y) {
                    x = y;
                    y = b;
                    ans ++;
                }else if(a > y) {
                    y = b;
                    x = b - 1;
                    ans += 2;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
