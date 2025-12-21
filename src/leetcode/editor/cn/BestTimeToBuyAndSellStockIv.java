//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1326 👎 0


package leetcode.editor.cn;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.Arrays;
import java.util.Map;

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            // 防止溢出 [0,n-1] -> [1,n] [0,k] -> [1,k+1]
            int[][][] dp = new int[n + 1][k + 2][2];
            for(int[][] mat : dp) {
                for(int[] row : mat) {
                    Arrays.fill(row, Integer.MIN_VALUE / 2);
                }
            }
            // 初始化边界状态
            for(int j = 1; j <= k + 1; j ++ ) {
                dp[0][j][0] = 0;
            }
            for(int i = 1; i <= n; i ++ ) {
                for(int j = 1; j <= k + 1; j ++ ) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i - 1]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i - 1]);
                }
            }
            return dp[n][k + 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
// 记忆化搜索
//    class Solution {
//        int[][][] memo;
//        public int maxProfit(int k, int[] prices) {
//            int n = prices.length;
//            memo = new int[n][k + 1][2];
//            for(int[][] m : memo) {
//                for(int[] row : m) {
//                    Arrays.fill(row, -1);
//                }
//            }
//
//            return dfs(n - 1, k, 0, prices);
//        }
//
//        int dfs(int i, int j, int hold, int[] prices) {
//            if(j < 0) {
//                return Integer.MIN_VALUE / 2;
//            }
//            if(i < 0) {
//                return hold == 0 ? 0 : Integer.MIN_VALUE / 2;
//            }
//            if(memo[i][j][hold] != -1) return memo[i][j][hold];
//            if(hold == 0) {
//                // 第i天不持有，一种情况是第i天卖出了，交易次数-1
//                memo[i][j][hold] = Math.max(dfs(i - 1, j, 0, prices), dfs(i - 1, j - 1, 1, prices) + prices[i]);
//            }else {
//                // 第i天持有，一种情况是第i天买入了，交易次数在卖出的时候才-1
//                memo[i][j][hold] = Math.max(dfs(i - 1, j, 1, prices), dfs(i - 1, j, 0, prices) - prices[i]);
//            }
//            return memo[i][j][hold];
//        }
//    }

}
