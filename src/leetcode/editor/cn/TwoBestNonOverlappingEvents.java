//给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。第 
//i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。你 最多 可以参加 两个时间不重叠 
//活动，使得它们的价值之和 最大 。 
//
// 请你返回价值之和的 最大值 。 
//
// 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。更具体的，如果你参加一个
//活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：events = [[1,3,2],[4,5,2],[2,4,3]]
//输出：4
//解释：选择绿色的活动 0 和 1 ，价值之和为 2 + 2 = 4 。
// 
//
// 示例 2： 
//
// 
//
// 输入：events = [[1,3,2],[4,5,2],[1,5,5]]
//输出：5
//解释：选择活动 2 ，价值和为 5 。
// 
//
// 示例 3： 
//
// 
//
// 输入：events = [[1,5,3],[1,5,1],[6,6,5]]
//输出：8
//解释：选择活动 0 和 2 ，价值之和为 3 + 5 = 8 。 
//
// 
//
// 提示： 
//
// 
// 2 <= events.length <= 10⁵ 
// events[i].length == 3 
// 1 <= startTimei <= endTimei <= 10⁹ 
// 1 <= valuei <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 堆（优先队列） 👍 79 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        Solution solution = new TwoBestNonOverlappingEvents().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTwoEvents(int[][] events) {
            // 按结束时间排序
            Arrays.sort(events, (a, b) -> {
                return a[1] - b[1];
            });

            // 单调栈维护，结束时间递增，价值递增
            List<int[]> list = new ArrayList<>();
            int ans = 0;
            // 哨兵节点
            list.add(new int[]{0, 0});
            for (int[] e : events) {
                // 从单调栈中找到最近的价值最大节点
                int[] last = list.get(search(list, e[0]));
                ans = Math.max(ans, last[1] + e[2]);
                if(e[2] > list.get(list.size() - 1)[1]) {
                    // 价值比栈顶还大，就加入单调栈
                    list.add(new int[]{e[1], e[2]});
                }
            }
            return ans;
        }

        int search(List<int[]> list, int target) {
            int l = -1, r = list.size();
            while(l + 1 < r) {
                int mid = (l + r) >> 1;
                if(list.get(mid)[0] < target) {
                    l = mid;
                }else {
                    r = mid;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
