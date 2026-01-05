//给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [21,4,7]
//输出：32
//解释：
//21 有 4 个因数：1, 3, 7, 21
//4 有 3 个因数：1, 2, 4
//7 有 2 个因数：1, 7
//答案仅为 21 的所有因数的和。
// 
//
// 示例 2: 
//
// 
//输入: nums = [21,21]
//输出: 64
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,2,3,4,5]
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 数学 👍 63 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
    public static void main(String[] args) {
        Solution solution = new FourDivisors().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumFourDivisors(int[] nums) {
            int ans = 0;
            for(int v : nums) {
                List<Integer> cnt = new ArrayList<>();
                for(int i = 1; i * i <= v; i ++ ) {
                    if(v % i == 0) {
                        cnt.add(i);
                        if(v != i * i) {
                            cnt.add(v / i);
                        }
                    }
                }
                if(cnt.size() == 4) {
                    for(int i = 0; i < 4; i ++ ) {
                        ans += cnt.get(i);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
