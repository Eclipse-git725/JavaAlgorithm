//给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: s = "aaab"
//输出: ""
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写字母 
// 
//
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 👍 568 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        System.out.println(solution.reorganizeString("aabbaab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String s) {
            int n = s.length();
            char[] str = s.toCharArray();
            int[] chs = new int[26];
            for(int i = 0; i < n; i ++ ) {
                chs[str[i] - 'a'] ++;
            }
            char[] ans = new char[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return b[0] - a[0];
            });

            for(int i = 0; i < 26; i ++ ) {
                if(chs[i] > 0) {
                    pq.add(new int[]{chs[i], i});
                }
            }

            int i = 0;
            while(!pq.isEmpty()) {
                int[] a = new int[2];
                int[] b = new int[2];
                if(!pq.isEmpty()) a = pq.poll();
                if(!pq.isEmpty()) b = pq.poll();
                ans[i ++] = (char)(a[1] + 'a');
                a[0] --;
                if(b[0] > 0) {
                    ans[i ++] = (char)(b[1] + 'a');
                    b[0] --;
                }else {
                    if(a[0] > 0) {
                        return "";
                    }
                }
                if(a[0] > 0) {
                    pq.add(a);
                }
                if(b.length > 0 && b[0] > 0) {
                    pq.add(b);
                }
            }

            return new String(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
