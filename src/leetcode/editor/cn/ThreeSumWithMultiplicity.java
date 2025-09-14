//给定一个整数数组
// arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且
// arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。 
//
// 由于结果会非常大，请返回 10⁹ + 7 的模。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//输出：20
//解释：
//按值枚举(arr[i], arr[j], arr[k])：
//(1, 2, 5) 出现 8 次；
//(1, 3, 4) 出现 8 次；
//(2, 2, 4) 出现 2 次；
//(2, 3, 3) 出现 2 次。
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,2,2,2,2], target = 5
//输出：12
//解释：
//arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
//我们从 [1,1] 中选择一个 1，有 2 种情况，
//从 [2,2,2,2] 中选出两个 2，有 6 种情况。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
//
// Related Topics 数组 哈希表 双指针 计数 排序 👍 161 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        Solution solution = new ThreeSumWithMultiplicity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumMulti(int[] arr, int target) {
            int n = arr.length;
            int ans = 0;
            int mod = 1_000_000_007;
            Map<Integer, Integer> total = new HashMap<>();
            for(int i = 0; i < n; i ++ ) {
                total.put(arr[i], total.getOrDefault(arr[i], 0) + 1);
            }
            for(int i = 1; i < n - 1; i ++ ) {
                Map<Integer, Integer> left = new HashMap<>();
                for(int j = 0; j < i; j ++ ) {
                    left.put(arr[j], left.getOrDefault(arr[j], 0) + 1);
                }
                for(int j = 0; j < i; j ++ ) {
                    int t = target - arr[i] - arr[j];
                    ans = (ans + total.getOrDefault(t, 0) - left.getOrDefault(t, 0) -
                            ((arr[i] == t) ? 1 : 0)) % mod;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
