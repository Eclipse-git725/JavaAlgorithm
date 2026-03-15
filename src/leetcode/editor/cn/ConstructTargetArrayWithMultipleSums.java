//给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作： 
//
// 
// 令 x 为你数组里所有元素的和 
// 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。 
// 你可以重复该过程任意次 
// 
//
// 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。 
//
// 
//
// 示例 1： 
//
// 输入：target = [9,3,5]
//输出：true
//解释：从 [1, 1, 1] 开始
//[1, 1, 1], 和为 3 ，选择下标 1
//[1, 3, 1], 和为 5， 选择下标 2
//[1, 3, 5], 和为 9， 选择下标 0
//[9, 3, 5] 完成
// 
//
// 示例 2： 
//
// 输入：target = [1,1,1,2]
//输出：false
//解释：不可能从 [1,1,1,1] 出发构造目标数组。
// 
//
// 示例 3： 
//
// 输入：target = [8,5]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// N == target.length 
// 1 <= target.length <= 5 * 10^4 
// 1 <= target[i] <= 10^9 
// 
//
// Related Topics 数组 堆（优先队列） 👍 117 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {
        Solution solution = new ConstructTargetArrayWithMultipleSums().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] target) {
            if(target.length == 1 && target[0] != 1) return false;
            PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> {
                return b.compareTo(a);
            });
            long sum = 0;
            for(int v : target) {
                pq.add((long)v);
                sum += v;
            }

            while(pq.peek() > 1) {
                long t = pq.poll(); // 目标数组中的最大值
                long k = sum - t;  // 除去最大值的和
                long maxv = t - k;
                // 将maxv更新成小于k的数
                if(maxv > k) {
                    maxv %= k;
                }
                if(maxv == 0 && k == 1) {
                    return true;
                }
                if(maxv < 1) {
                    return false;
                }
                pq.add(maxv);
                sum = maxv + k;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
