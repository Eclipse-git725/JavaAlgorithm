//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [[1,2],[1,4],[1,6]]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [[1,1],[1,1]]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为 升序排列 
// 
// 1 <= k <= 10⁴ 
// k <= nums1.length * nums2.length 
// 
//
// Related Topics 数组 堆（优先队列） 👍 717 👎 0


package leetcode.editor.cn;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums1.length, m = nums2.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]);
            });

            pq.add(new int[]{0, 0});
            Set<Long> s = new HashSet<>();
            s.add(0L);

            for(int i = 0; i < k; i ++ ) {
                int[] pair = pq.poll();
                int x = pair[0], y = pair[1];
                List<Integer> list = new ArrayList<>();
                list.add(nums1[x]);
                list.add(nums2[y]);
                ans.add(list);

                // 把下一层两个数对加入堆
                if(x + 1 < n && !s.contains((x + 1L) * m + y)) {
                    pq.add(new int[]{x + 1, y});
                    s.add((x + 1L) * m + y);
                }
                if(y + 1 < m && !s.contains(x * m + y + 1L)) {
                    pq.add(new int[]{x, y + 1});
                    s.add(x * m + y + 1L);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
