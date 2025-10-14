//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 889 👎 0


package leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        System.out.println(solution.addStrings("123", "456"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int n = num1.length(), m = num2.length();
            StringBuilder ans = new StringBuilder();
            int r = 0;
            int i = n - 1, j = m - 1;
            while(i >= 0 && j >= 0) {
                Integer sum =(num1.charAt(i) - '0') + (num2.charAt(j) - '0');
                ans.append(String.valueOf((sum + r) % 10));
                i --;
                j --;
                r = (sum + r) / 10;
            }
            while(i >= 0) {
                Integer sum = Integer.valueOf(num1.charAt(i));
                ans.append(String.valueOf((sum + r) % 10));
                i --;
                r = (sum + r) % 10;
            }
            while(j >= 0) {
                Integer sum = Integer.valueOf(num2.charAt(j));
                ans.append(String.valueOf((sum + r) % 10));
                j --;
                r = (sum + r) % 10;
            }
            if(r != 0) {
                ans.append("1");
            }
            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
