//如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。 
//
// 
// 例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。 
// 
//
// 给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在
// word 中出现多次，那么应当对 每次出现 分别计数。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aba"
//输出：4
//解释：4 个最美子字符串如下所示：
//- "aba" -> "a"
//- "aba" -> "b"
//- "aba" -> "a"
//- "aba" -> "aba"
// 
//
// 示例 2： 
//
// 
//输入：word = "aabb"
//输出：9
//解释：9 个最美子字符串如下所示：
//- "aabb" -> "a"
//- "aabb" -> "aa"
//- "aabb" -> "aab"
//- "aabb" -> "aabb"
//- "aabb" -> "a"
//- "aabb" -> "abb"
//- "aabb" -> "b"
//- "aabb" -> "bb"
//- "aabb" -> "b"
// 
//
// 示例 3： 
//
// 
//输入：word = "he"
//输出：2
//解释：2 个最美子字符串如下所示：
//- "he" -> "h"
//- "he" -> "e"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 由从 'a' 到 'j' 的小写英文字母组成 
// 
//
// Related Topics 位运算 哈希表 字符串 前缀和 👍 114 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWonderfulSubstrings {
    public static void main(String[] args) {
        Solution solution = new NumberOfWonderfulSubstrings().new Solution();
        solution.wonderfulSubstrings("abca");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long wonderfulSubstrings(String word) {
            long ans = 0;
            int curMask = 0;
            // target 存完美子串，0表示所有字符都是偶数次数
            int[] target = new int[11];
            target[0] = 0;
            for(int i = 1; i <= 10; i ++ ) {
                target[i] = 1 << (i - 1);
            }

            Map<Integer, Integer> map = new HashMap<>();
            // 要把空前缀加入，来计算0开头的字符串
            map.put(0, 1);
            for(int i = 0; i < word.length(); i ++ ) {
                char ch = word.charAt(i);
                curMask ^= 1 << (ch - 'a');
                for(int j = 0; j <= 10; j ++ ) {
                    // 求出能和j构成完美子串的i有多少个
                    ans += map.getOrDefault(curMask ^ target[j], 0);
                }
                map.put(curMask, map.getOrDefault(curMask, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
