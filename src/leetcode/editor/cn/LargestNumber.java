//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1373 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber{
  public static void main(String[] args) {
       Solution solution = new LargestNumber().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] num = new String[n];
        for(int i = 0; i < n; i ++ ) {
            num[i] = String.valueOf(nums[i]);
        }
        // Arrays.sort 比较函数返回负数->a排在b前面
        // compareTo 返回负数，num1 > num2
        Arrays.sort(num, (a, b) -> {
            String num1 = a + b, num2 = b + a;
            return num2.compareTo(num1);
        });
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < num.length; i ++ ) {
            ans.append(num[i]);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < ans.length(); i ++ ) {
            if(res.length() == 0 && ans.charAt(i) == '0') {
                continue;
            }else {
                res.append(ans.charAt(i));
            }
        }
        if(res.length() == 0) return "0";
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
