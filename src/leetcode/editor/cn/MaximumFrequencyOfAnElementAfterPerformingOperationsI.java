//给你一个整数数组 nums 和两个整数 k 和 numOperations 。 
//
// 你必须对 nums 执行 操作 numOperations 次。每次操作中，你可以： 
//
// 
// 选择一个下标 i ，它在之前的操作中 没有 被选择过。 
// 将 nums[i] 增加范围 [-k, k] 中的一个整数。 
// 
//
// 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。 
//
// 一个元素 x 的 频率 指的是它在数组中出现的次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,4,5], k = 1, numOperations = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。 
// 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [5,11,20,20], k = 5, numOperations = 1 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 0 <= k <= 10⁵ 
// 0 <= numOperations <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 排序 滑动窗口 👍 11 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public static void main(String[] args) {
        Solution solution = new MaximumFrequencyOfAnElementAfterPerformingOperationsI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            int ans = 0;
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            int minv = Integer.MAX_VALUE, maxv = 0;
            for(int v : nums) {
                map.put(v, map.getOrDefault(v, 0) + 1);
                minv = Math.min(v, minv);
                maxv = Math.max(v, maxv);
            }

            for(int v = minv; v <= maxv; v ++) {
                int l = lower_bound(nums, v - k);
                int r = lower_bound(nums, v + k + 1);
                ans = Math.max(ans, Math.min(r - l, numOperations + map.getOrDefault(v, 0)));
            }
            return ans;
        }

        public int lower_bound(int[] nums, int target) {
            int n = nums.length;
            int l = 0, r = n;
            while(l < r) {
                int mid = (l + r) >> 1;
                if(nums[mid] < target) {
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
