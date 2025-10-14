//一个魔法师有许多不同的咒语。 
//
// 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。 
//
// 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] +
// 1 或者 power[i] + 2 的咒语。 
//
// 每个咒语最多只能被使用 一次 。 
//
// 请你返回这个魔法师可以达到的伤害值之和的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：power = [1,1,3,4] 
// 
//
// 输出：6 
//
// 解释： 
//
// 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。 
//
// 示例 2： 
//
// 
// 输入：power = [7,1,6,6] 
// 
//
// 输出：13 
//
// 解释： 
//
// 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。 
//
// 
//
// 提示： 
//
// 
// 1 <= power.length <= 10⁵ 
// 1 <= power[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 动态规划 计数 排序 👍 73 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumTotalDamageWithSpellCasting {
    public static void main(String[] args) {
        Solution solution = new MaximumTotalDamageWithSpellCasting().new Solution();
        System.out.println(solution.maximumTotalDamage(new int[]{7,1,6,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTotalDamage(int[] power) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = power.length;
            for (int x : power) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            int[] a = new int[n];
            int k = 0;
            for (int key : map.keySet()) {
                a[k++] = key;
            }
            Arrays.sort(a);
            long[] dp = new long[n];
            dp[0] = (long)a[0] * map.getOrDefault(a[0], 0);
            long ans = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1];
                int j = i - 1;
                while (j >= 0) {
                    if(a[j] == 0) break;
                    if (a[i] - a[j] <= 2) {
                        j--;
                    } else {
                        break;
                    }
                }
                if (j >= 0) {
                    dp[i] = Math.max(dp[i], dp[j] + (long)a[i] * map.getOrDefault(a[i], 0));
                }else {
                    dp[i] = Math.max(dp[i], (long)a[i] * map.getOrDefault(a[i], 0));
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
