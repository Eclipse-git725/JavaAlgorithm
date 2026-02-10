//给你一个整数数组 nums 和一个整数 k。 
//
// 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。 
//
// 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。 
//
// 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。 
//
// 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。 
//
// 
//
// 示例 1: 
//
// 
// 输入：nums = [2,1,5], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 移除 nums[2] = 5 得到 nums = [2, 1]。 
// 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。 
// 
//
// 示例 2: 
//
// 
// 输入：nums = [1,6,2,9], k = 3 
// 
//
// 输出：2 
//
// 解释： 
//
// 
// 移除 nums[0] = 1 和 nums[3] = 9 得到 nums = [6, 2]。 
// 现在 max = 6, min = 2，且 max <= min * k，因为 6 <= 2 * 3。因此，答案是 2。 
// 
//
// 示例 3: 
//
// 
// 输入：nums = [4,6], k = 2 
// 
//
// 输出：0 
//
// 解释： 
//
// 
// 由于 nums 已经平衡，因为 6 <= 4 * 2，所以不需要移除任何元素。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 数组 排序 滑动窗口 👍 49 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {
    public static void main(String[] args) {
        Solution solution = new MinimumRemovalsToBalanceArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRemoval(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;

            int l = 0;
            int maxlen = 0;
            for(int r = 0; r < n; r ++ ) {
                while(l < r && (double)nums[r] / k > nums[l]) {
                    l ++;
                }
                maxlen = Math.max(maxlen, r - l + 1);
            }
            return n - maxlen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
