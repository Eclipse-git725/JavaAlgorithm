//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 排序 👍 1738 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> path = new ArrayList<>();
            int[] st = new int[nums.length];
            Arrays.sort(nums);
            dfs(0, nums, path, st);
            return ans;
        }

        void dfs(int index, int[] nums, List<Integer> path, int[] st) {
            if(index == nums.length) {
                List<Integer> tmp = new ArrayList<>(path);
                ans.add(tmp);
                return;
            }
            for(int i = 0; i < nums.length; i ++ ) {
                if(i > 0 && st[i - 1] == 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if(st[i] == 0) {
                    path.add(nums[i]);
                    st[i] = 1;
                    dfs(index + 1, nums, path, st);
                    path.remove(path.size() - 1);
                    st[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
