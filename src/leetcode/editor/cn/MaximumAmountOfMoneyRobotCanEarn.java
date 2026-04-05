//给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右
//或向下移动。 
//
// 网格中的每个单元格包含一个值 coins[i][j]： 
//
// 
// 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。 
// 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。 
// 
//
// 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。 
//
// 注意：机器人的总金币数可以是负数。 
//
// 返回机器人在路径上可以获得的 最大金币数 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： coins = [[0,1,-1],[1,-2,3],[2,-3,4]] 
// 
//
// 输出： 8 
//
// 解释： 
//
// 一个获得最多金币的最优路径如下： 
//
// 
// 从 (0, 0) 出发，初始金币为 0（总金币 = 0）。 
// 移动到 (0, 1)，获得 1 枚金币（总金币 = 0 + 1 = 1）。 
// 移动到 (1, 1)，遇到强盗抢走 2 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = 1）。 
// 移动到 (1, 2)，获得 3 枚金币（总金币 = 1 + 3 = 4）。 
// 移动到 (2, 2)，获得 4 枚金币（总金币 = 4 + 4 = 8）。 
// 
//
// 示例 2： 
//
// 
// 输入： coins = [[10,10,10],[10,10,10]] 
// 
//
// 输出： 40 
//
// 解释： 
//
// 一个获得最多金币的最优路径如下： 
//
// 
// 从 (0, 0) 出发，初始金币为 10（总金币 = 10）。 
// 移动到 (0, 1)，获得 10 枚金币（总金币 = 10 + 10 = 20）。 
// 移动到 (0, 2)，再获得 10 枚金币（总金币 = 20 + 10 = 30）。 
// 移动到 (1, 2)，获得 10 枚金币（总金币 = 30 + 10 = 40）。 
// 
//
// 
//
// 提示： 
//
// 
// m == coins.length 
// n == coins[i].length 
// 1 <= m, n <= 500 
// -1000 <= coins[i][j] <= 1000 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 35 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumAmountOfMoneyRobotCanEarn {
    public static void main(String[] args) {
        Solution solution = new MaximumAmountOfMoneyRobotCanEarn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumAmount(int[][] coins) {
            int m = coins.length, n = coins[0].length;
            int[][][] dp = new int[m][n][3];
            for(int[][] a : dp) {
                for(int[] b : a) {
                    Arrays.fill(b, Integer.MIN_VALUE / 2);
                }
            }
            if(coins[0][0] < 0) {
                dp[0][0][1] = 0;
                dp[0][0][0] = coins[0][0];
            }else {
                dp[0][0][0] = coins[0][0];
            }

            // 初始化第一行
            for(int j = 1; j < n; j ++ ) {
                if(coins[0][j] < 0) {
                    dp[0][j][0] = dp[0][j - 1][0] + coins[0][j];
                    for(int k = 1; k < 3; k ++ ) {
                        dp[0][j][k] = Math.max(dp[0][j - 1][k - 1], dp[0][j - 1][k] + coins[0][j]);
                    }
                }else {
                    for(int k = 0; k < 3; k ++ ) {
                        dp[0][j][k] = dp[0][j - 1][k] + coins[0][j];
                    }
                }
            }
            // 初始化第一列
            for(int i = 1; i < m; i ++ ) {
                if(coins[i][0] < 0) {
                    dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
                    for(int k = 1; k < 3; k ++ ) {
                        dp[i][0][k] = Math.max(dp[i - 1][0][k - 1], dp[i - 1][0][k] + coins[i][0]);
                    }
                }else {
                    for(int k = 0; k < 3; k ++ ) {
                        dp[i][0][k] = dp[i - 1][0][k] + coins[i][0];
                    }
                }
            }

            for(int i = 1; i < m; i ++ ) {
                for(int j = 1; j < n; j ++ ) {
                    if(coins[i][j] < 0) {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];
                        for(int k = 1; k < 3; k ++ ) {
                            dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1]), Math.max(dp[i - 1][j][k] + coins[i][j], dp[i][j - 1][k] + coins[i][j]));
                        }
                    }else {
                        for(int k = 0; k < 3; k ++ ) {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) + coins[i][j];
                        }
                    }
                }
            }
            return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
