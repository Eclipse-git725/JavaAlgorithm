//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1327 👎 0

  
package leetcode.editor.cn;
public class AddBinary{
  public static void main(String[] args) {
       Solution solution = new AddBinary().new Solution();
       solution.addBinary("11", "1");
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        int i = n - 1, j = m - 1;
        StringBuilder ans = new StringBuilder();
        int r = 0;
        while(i >= 0 && j >= 0) {
            int c = Integer.valueOf(a.charAt(i) - '0');
            int d = Integer.valueOf(b.charAt(j) - '0');
            ans.append(((c + d + r) % 2));
            r = (c + d + r) / 2;
            i --;
            j --;
        }
        while(i >= 0) {
            int c = Integer.valueOf(a.charAt(i) - '0');
            ans.append((c + r) % 2);
            r = (c + r) / 2;
            i --;
        }
        while(j >= 0) {
            int c = Integer.valueOf(b.charAt(j) - '0');
            ans.append((c + r) % 2);
            r = (c + r) / 2;
            j --;
        }
        if(r != 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
