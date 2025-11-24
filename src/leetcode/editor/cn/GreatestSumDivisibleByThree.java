//给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 
//输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 388 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class GreatestSumDivisibleByThree{
  public static void main(String[] args) {
       Solution solution = new GreatestSumDivisibleByThree().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = 0; // 什么都不选是0
        dp[0][nums[0] % 3] = nums[0];
        for(int i = 1; i < n; i ++ ) {
            int x = nums[i];
            for(int j = 0; j < 3; j ++ ) {
                // 不选
                dp[i][j] = dp[i - 1][j];
                // 选
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][(j - x % 3 + 3) % 3] + x);
            }

        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
