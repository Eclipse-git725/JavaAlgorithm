package algorithm;

/**
 * 文件名称: Algorithm1.java
 * 作者: gxy
 * 创建日期: 2025/4/21
 * 描述: 小于n的最大数，给定一个数组m和一个数字n，用数组里的数字组成小于n的最大数
 */
public class Algorithm1 {
    public static void main(String[] args) {
        int[] nums = {2, 4};
        int n = 9;
        System.out.println(getMaxNumber(nums, n));
    }

    public static int getMaxNumber(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for(int i = 1; i <= n; i ++ ) {
            for(int j = 0; j <= target; j ++ ) {
                dp[i][j] = dp[i - 1][j]; // 不选当前数字
                if(j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return dp[n][target];
    }
}
