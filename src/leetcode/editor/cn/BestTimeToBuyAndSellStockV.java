//给你一个整数数组 prices，其中 prices[i] 是第 i 天股票的价格（美元），以及一个整数 k。 
//
// 你最多可以进行 k 笔交易，每笔交易可以是以下任一类型： 
//
// 
// 普通交易：在第 i 天买入，然后在之后的第 j 天卖出，其中 i < j。你的利润是 prices[j] - prices[i]。 
// 做空交易：在第 i 天卖出，然后在之后的第 j 天买回，其中 i < j。你的利润是 prices[i] - prices[j]。 
// 
//
// 注意：你必须在开始下一笔交易之前完成当前交易。此外，你不能在已经进行买入或卖出操作的同一天再次进行买入或卖出操作。 
//
// 通过进行 最多 k 笔交易，返回你可以获得的最大总利润。 
//
// 
//
// 示例 1: 
//
// 
// 输入: prices = [1,7,9,8,2], k = 2 
// 
//
// 输出: 14 
//
// 解释: 我们可以通过 2 笔交易获得 14 美元的利润：
//
// 
// 一笔普通交易：第 0 天以 1 美元买入，第 2 天以 9 美元卖出。 
// 一笔做空交易：第 3 天以 8 美元卖出，第 4 天以 2 美元买回。 
// 
//
// 示例 2: 
//
// 
// 输入: prices = [12,16,19,19,8,1,19,13,9], k = 3 
// 
//
// 输出: 36 
//
// 解释: 我们可以通过 3 笔交易获得 36 美元的利润：
//
// 
// 一笔普通交易：第 0 天以 12 美元买入，第 2 天以 19 美元卖出。 
// 一笔做空交易：第 3 天以 19 美元卖出，第 4 天以 8 美元买回。 
// 一笔普通交易：第 5 天以 1 美元买入，第 6 天以 19 美元卖出。 
// 
//
// 
//
// 提示: 
//
// 
// 2 <= prices.length <= 10³ 
// 1 <= prices[i] <= 10⁹ 
// 1 <= k <= prices.length / 2 
// 
//
// Related Topics 数组 动态规划 👍 25 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockV{
  public static void main(String[] args) {
       Solution solution = new BestTimeToBuyAndSellStockV().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumProfit(int[] prices, int k) {


        int n = prices.length;
        // 防止溢出 [0,n-1] -> [1,n] [0,k] -> [1,k+1]
        // 状态重新定义 0:表示不持有也不欠股票，1:表示做多，持有股票，2:表示做空，欠股票
        long[][][] dp = new long[n + 1][k + 2][3];
        for(long[][] mat : dp) {
            for(long[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE / 2);
            }
        }
        // 初始化边界状态
        for(int j = 1; j <= k + 1; j ++ ) {
            dp[0][j][0] = 0;
        }
        for(int i = 1; i <= n; i ++ ) {
            for(int j = 1; j <= k + 1; j ++ ) {
                // 0从1转移过来表示，当天卖出了股票，从2转移过来表示当天要买入还欠的股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j - 1][1] + prices[i - 1],
                        dp[i - 1][j - 1][2] - prices[i - 1]));
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i - 1]);
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j][0] + prices[i - 1]);
            }
        }
        return dp[n][k + 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
