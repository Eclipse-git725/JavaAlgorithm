//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3371 👎 0


package leetcode.editor.cn;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("a", "aa");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s1, String t1) {
            char[] s = s1.toCharArray();
            char[] t = t1.toCharArray();
            int[] ch1 = new int[200];
            int[] ch2 = new int[200];
            String ans = s1;
            for(int i = 0; i < t1.length(); i ++ ) {
                ch2[t[i]] ++;
            }

            int l = 0, r = 0;
            boolean f = false;
            while(r < s.length) {
                ch1[s[r]] ++;
                boolean f1 = true;
                for(int i = 0; i < 200; i ++ ) {
                    if(ch1[i] < ch2[i]) {
                        f1 = false;
                        break;
                    }
                }
                if(f1) {
                    f = true;
                    while(l < r && ch1[s[l]] > ch2[s[l]]) {
                        ch1[s[l]] --;
                        l ++;
                    }
                    if(r - l + 1 < ans.length()) {
                        ans = s1.substring(l, r + 1);
                    }
                }
                r ++;
            }
            if(!f) {
                return "";
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
