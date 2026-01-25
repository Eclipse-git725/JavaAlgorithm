//给你一个数组 nums，你可以执行以下操作任意次数： 
//
// 
// 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。 
// 用它们的和替换这对元素。 
// 
//
// 返回将数组变为 非递减 所需的 最小操作次数 。 
//
// 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [5,2,3,1] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 
// 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。 
// 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。 
// 
//
// 数组 nums 在两次操作后变为非递减。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,2] 
// 
//
// 输出： 0 
//
// 解释： 
//
// 数组 nums 已经是非递减的。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// -1000 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 链表 双向链表 有序集合 模拟 堆（优先队列） 👍 17 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovalToSortArrayI {
    public static void main(String[] args) {
        Solution solution = new MinimumPairRemovalToSortArrayI().new Solution();
        solution.minimumPairRemoval(new int[]{5, 2, 3, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumPairRemoval(int[] nums) {
            int n = nums.length;
            int ans = 0;
            List<Integer> num = new ArrayList<>();
            for(int i = 0; i < n; i ++ ) {
                num.add(nums[i]);
            }
            while(true) {
                boolean flag = true;
                for(int i = 0; i < num.size() - 1; i ++ ) {
                    if(num.get(i + 1) < num.get(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return ans;
                }
                int sum = Integer.MAX_VALUE;
                int t = 0;
                for(int i = 0; i < num.size() - 1; i ++ ) {
                    if(num.get(i) + num.get(i + 1) < sum) {
                        sum = num.get(i) + num.get(i + 1);
                        t = i;
                    }
                }
                num.remove(t);
                num.remove(t);
                num.add(t, sum);
                ans ++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
