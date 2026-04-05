//给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。 
//
// 你可以对两个字符串中的 任意一个 执行以下操作 任意 次： 
//
// 
// 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。 
// 
//
// 
//
// 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "abcdba", s2 = "cabdab"
//输出：true
//解释：我们可以对 s1 执行以下操作：
//- 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbadba" 。
//- 选择下标 i = 2 ，j = 4 ，得到字符串 s1 = "cbbdaa" 。
//- 选择下标 i = 1 ，j = 5 ，得到字符串 s1 = "cabdab" = s2 。
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abe", s2 = "bea"
//输出：false
//解释：无法让两个字符串相等。
// 
//
// 
//
// 提示： 
//
// 
// n == s1.length == s2.length 
// 1 <= n <= 10⁵ 
// s1 和 s2 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 排序 👍 12 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfStringsCanBeMadeEqualWithOperationsIi {
    public static void main(String[] args) {
        Solution solution = new CheckIfStringsCanBeMadeEqualWithOperationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStrings(String s1, String s2) {
            int[][] cnt1 = new int[2][26];
            int[][] cnt2 = new int[2][26];
            int n = s1.length();
            for(int i = 0; i < n; i ++ ) {
                cnt1[i % 2][s1.charAt(i) - 'a'] ++;
                cnt2[i % 2][s2.charAt(i) - 'a'] ++;
            }
            if(Arrays.deepEquals(cnt1, cnt2)) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
