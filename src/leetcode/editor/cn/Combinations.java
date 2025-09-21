//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1798 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> path = new ArrayList<>();
            dfs(0, 1, n, k, path);
            return ans;
        }

        void dfs(int index, int j, int n, int k, List<Integer> path) {
            if(index == k) {
                if(path.size() == k) {
                    List<Integer> tmp = new ArrayList<>(path);
                    ans.add(tmp);
                }
                return;
            }
            for(int i = j; i <= n; i ++ ) {
                path.add(i);
                dfs(index + 1, i + 1, n, k, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
