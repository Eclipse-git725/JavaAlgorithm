//给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。从其中取任意三个不同的点组成三角形，返回能组成的
//最大三角形的面积。与真实值误差在 10⁻⁵ 内的答案将会视为正确答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出：2.00000
//解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,0],[0,0],[0,1]]
//输出：0.50000
// 
//
// 
//
// 提示： 
//
// 
// 3 <= points.length <= 50 
// -50 <= xi, yi <= 50 
// 给出的所有点 互不相同 
// 
//
// Related Topics 几何 数组 数学 👍 221 👎 0

  
package leetcode.editor.cn;
public class LargestTriangleArea{
  public static void main(String[] args) {
       Solution solution = new LargestTriangleArea().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        int n = points.length;
        for(int i = 0; i < n - 2; i ++ ) {
            for(int j = i + 1; j < n - 1; j ++ ) {
                for(int k = j + 1; k < n; k ++ ) {
                    double x1 = points[i][0] - points[j][0];
                    double y1 = points[i][1] - points[j][1];
                    double x2 = points[i][0] - points[k][0];
                    double y2 = points[i][1] - points[k][1];
                    ans = Math.max(ans, Math.abs(x1 * y2 - x2 * y1) / 2);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
