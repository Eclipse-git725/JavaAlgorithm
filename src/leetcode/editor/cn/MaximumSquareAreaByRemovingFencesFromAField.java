//有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组
// hFences 和 vFences 给出。 
//
// 水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, 
//vFences[i]) 。 
//
// 返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。 
//
// 由于答案可能很大，所以请返回结果对 10⁹ + 7 取余 后的值。 
//
// 注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）以及两个垂直栅栏（坐标 (1, 1) 到 (
//m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：m = 4, n = 3, hFences = [2,3], vFences = [2]
//输出：4
//解释：移除位于 2 的水平栅栏和位于 2 的垂直栅栏将得到一个面积为 4 的正方形田地。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：m = 6, n = 7, hFences = [2], vFences = [4]
//输出：-1
//解释：可以证明无法通过移除栅栏形成正方形田地。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m, n <= 10⁹ 
// 1 <= hFences.length, vFences.length <= 600 
// 1 < hFences[i] < m 
// 1 < vFences[i] < n 
// hFences 和 vFences 中的元素是唯一的。 
// 
//
// Related Topics 数组 哈希表 枚举 👍 18 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquareAreaByRemovingFencesFromAField{
  public static void main(String[] args) {
       Solution solution = new MaximumSquareAreaByRemovingFencesFromAField().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> h = f(hFences, m);
        Set<Integer> v = f(vFences, n);
        long ans = -1;
        for(int x : h) {
            if(v.contains(x)) {
                ans = Math.max(ans, x);
            }
        }
        if(ans < 0) {
            return -1;
        }
        return (int)(ans * ans % 1_000_000_007);
    }

    Set<Integer> f(int[] a, int m) {
        Set<Integer> ans = new HashSet<>();
        int n = a.length;
        int[] b = Arrays.copyOf(a, n + 2);
        b[n] = 1;
        b[n + 1] = m;
        Arrays.sort(b);

        for(int i = 0; i < n + 2; i ++ ) {
            for(int j = i + 1; j < n + 2; j ++ ) {
                ans.add(b[j] - b[i]);
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
