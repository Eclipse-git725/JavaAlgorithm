//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
//
// Related Topics 数组 双指针 排序 👍 168 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            for(int i = 0; i < n - 2; i ++ ) {
                int l = i + 1, r = n - 1;
                if(i > 0 && nums[i] == nums[i - 1]) continue;
                while(l < r) {
                    if(nums[i] + nums[l] + nums[r] < 0) {
                        l ++;
                    }else if(nums[i] + nums[l] + nums[r] == 0) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[l]);
                        res.add(nums[r]);
                        ans.add(res);
                        while(l < r && nums[l + 1] == nums[l]) {
                            l ++;
                        }
                        l ++;
                        while(l < r && nums[r - 1] == nums[r]) {
                            r --;
                        }
                        r --;
                    }else {
                        r --;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
