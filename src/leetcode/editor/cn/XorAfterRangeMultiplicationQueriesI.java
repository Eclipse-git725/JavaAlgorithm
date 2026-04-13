//给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]
//。 
//
// 对于每个查询，按以下步骤执行操作： 
//
// 
// 设定 idx = li。 
// 当 idx <= ri 时： 
// 
// 更新：nums[idx] = (nums[idx] * vi) % (10⁹ + 7) 
// 将 idx += ki。 
// 
// 
//
// 在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,1,1], queries = [[0,2,1,4]] 
// 
//
// 输出： 4 
//
// 解释： 
//
// 
// 唯一的查询 [0, 2, 1, 4] 将下标 0 到下标 2 的每个元素乘以 4。 
// 数组从 [1, 1, 1] 变为 [4, 4, 4]。 
// 所有元素的异或为 4 ^ 4 ^ 4 = 4。 
// 
//
// 示例 2： 
//
// 
// 输入： nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]] 
// 
//
// 输出： 31 
//
// 解释： 
//
// 
// 第一个查询 [1, 4, 2, 3] 将下标 1 和 3 的元素乘以 3，数组变为 [2, 9, 1, 15, 4]。 
// 第二个查询 [0, 2, 1, 2] 将下标 0、1 和 2 的元素乘以 2，数组变为 [4, 18, 2, 15, 4]。 
// 所有元素的异或为 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 10³ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= q == queries.length <= 10³ 
// queries[i] = [li, ri, ki, vi] 
// 0 <= li <= ri < n 
// 1 <= ki <= n 
// 1 <= vi <= 10⁵ 
// 
//
// Related Topics 数组 分治 模拟 👍 14 👎 0


package leetcode.editor.cn;

public class XorAfterRangeMultiplicationQueriesI {
    public static void main(String[] args) {
        Solution solution = new XorAfterRangeMultiplicationQueriesI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int xorAfterQueries(int[] nums, int[][] queries) {
            int ans = 0;
            int n = nums.length;
            int mod = 1_000_000_007;
            for(int[] q : queries) {
                int l = q[0], r = q[1], k = q[2], v = q[3];
                for(int i = l; i <= r; i += k) {
                    nums[i] = (int)((long)nums[i] * v % mod);
                }
            }
            for(int i = 0; i < n; i ++ ) {
                ans = (ans ^ nums[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
