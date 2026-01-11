//给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 
//
// 提示: 
//
// 
// 0 <= s1.length, s2.length <= 1000 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 450 👎 0


package leetcode.editor.cn;

public class MinimumAsciiDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution solution = new MinimumAsciiDeleteSumForTwoStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int sum1 = 0, sum2 = 0;
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            int n = s1.length(), m = s2.length();

            for(char c : ch1) {
                sum1 += c;
            }

            for(char c : ch2) {
                sum2 += c;
            }

            // 计算最多保留的ASCII之和，而不是长度
            int[][] dp = new int[n + 1][m + 1];
            for(int i = 0; i < n; i ++ ) {
                for(int j = 0; j < m; j ++ ) {
                    if(ch1[i] == ch2[j]) {
                        dp[i + 1][j + 1] = dp[i][j] + ch1[i] * 2;
                    }else {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            return sum1 + sum2 - dp[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
