//给你一个整数 n。 
//
// 定义它的 镜像距离 为：abs(n - reverse(n))，其中 reverse(n) 表示将 n 的数字反转后形成的整数。 
//
// 返回表示 n 的镜像距离的整数。 
//
// 其中，abs(x) 表示 x 的绝对值。 
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 25 
// 
//
// 输出： 27 
//
// 解释： 
//
// 
// reverse(25) = 52。 
// 因此，答案为 abs(25 - 52) = 27。 
// 
//
// 示例 2： 
//
// 
// 输入： n = 10 
// 
//
// 输出： 9 
//
// 解释： 
//
// 
// reverse(10) = 01，即 1。 
// 因此，答案为 abs(10 - 1) = 9。 
// 
//
// 示例 3： 
//
// 
// 输入： n = 7 
// 
//
// 输出： 0 
//
// 解释： 
//
// 
// reverse(7) = 7。 
// 因此，答案为 abs(7 - 7) = 0。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数学 👍 7 👎 0

  
package leetcode.editor.cn;
public class MirrorDistanceOfAnInteger{
  public static void main(String[] args) {
       Solution solution = new MirrorDistanceOfAnInteger().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mirrorDistance(int n) {
        int re = 0;
        int v = n;
        while(v != 0) {
            re = re * 10 + v % 10;
            v /= 10;
        }
        return Math.abs(re - n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
