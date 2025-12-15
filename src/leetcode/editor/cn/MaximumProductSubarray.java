//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 请注意，一个只包含一个元素的数组的乘积是这个元素的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2506 👎 0


package leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int ans = nums[0];
            int maxv = nums[0], minv = nums[0];
            for(int i = 1; i < n; i ++ ) {
                int t = maxv;
                maxv = Math.max(nums[i], Math.max(maxv * nums[i], minv * nums[i]));
                minv = Math.min(nums[i], Math.min(t * nums[i], minv * nums[i]));
                ans = Math.max(ans, maxv);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
