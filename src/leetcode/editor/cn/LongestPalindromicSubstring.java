//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7816 👎 0

  
package leetcode.editor.cn;
public class LongestPalindromicSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // dp[i][j] 表示字符串s的i-j是否为回文串
        boolean[][] dp = new boolean[n][n];
        int l = 0, r = 0;
        for(int i = 0; i < n; i ++ ) {
            dp[i][i] = true;
        }
        for(int len = 2; len <= n; len ++ ) {
            for(int i = 0; i + len - 1 < n; i ++ ) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(len == 2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i][j] || dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j]) {
                    if(j - i > r - l) {
                        r = j;
                        l = i;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
