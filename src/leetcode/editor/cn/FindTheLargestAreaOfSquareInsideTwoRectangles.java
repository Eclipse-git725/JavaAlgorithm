//在二维平面上存在 n 个矩形。给你两个下标从 0 开始的二维整数数组 bottomLeft 和 topRight，两个数组的大小都是 n x 2 ，其中 
//bottomLeft[i] 和 topRight[i] 分别代表第 i 个矩形的 左下角 和 右上角 坐标。 
//
// 我们定义 向右 的方向为 x 轴正半轴（x 坐标增加），向左 的方向为 x 轴负半轴（x 坐标减少）。同样地，定义 向上 的方向为 y 轴正半轴（y 坐标
//增加），向下 的方向为 y 轴负半轴（y 坐标减少）。 
//
// 你可以选择一个区域，该区域由两个矩形的 交集 形成。你需要找出能够放入该区域 内 的 最大 正方形面积，并选择最优解。 
//
// 返回能够放入交集区域的正方形的 最大 可能面积，如果矩形之间不存在任何交集区域，则返回 0。 
//
// 
//
// 示例 1： 
// 
// 
//输入：bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
//输出：1
//解释：边长为 1 的正方形可以放入矩形 0 和矩形 1 的交集区域，或矩形 1 和矩形 2 的交集区域。因此最大面积是边长 * 边长，即 1 * 1 = 1
//。
//可以证明，边长更大的正方形无法放入任何交集区域。
// 
//
// 示例 2： 
// 
// 
//输入：bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]
//输出：1
//解释：边长为 1 的正方形可以放入矩形 0 和矩形 1，矩形 1 和矩形 2，或所有三个矩形的交集区域。因此最大面积是边长 * 边长，即 1 * 1 = 1
//。
//可以证明，边长更大的正方形无法放入任何交集区域。
//请注意，区域可以由多于两个矩形的交集构成。
// 
//
// 示例 3： 
// 
// 
//输入：bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]
//输出：0
//解释：不存在相交的矩形，因此，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == bottomLeft.length == topRight.length 
// 2 <= n <= 10³ 
// bottomLeft[i].length == topRight[i].length == 2 
// 1 <= bottomLeft[i][0], bottomLeft[i][1] <= 10⁷ 
// 1 <= topRight[i][0], topRight[i][1] <= 10⁷ 
// bottomLeft[i][0] < topRight[i][0] 
// bottomLeft[i][1] < topRight[i][1] 
// 
//
// Related Topics 几何 数组 数学 👍 15 👎 0

  
package leetcode.editor.cn;
public class FindTheLargestAreaOfSquareInsideTwoRectangles{
  public static void main(String[] args) {
       Solution solution = new FindTheLargestAreaOfSquareInsideTwoRectangles().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        int ans = 0;
        // 题意是任选两个矩形的重叠区域，找最大的重叠正方形的边长，并不是多个矩形的重叠
        // 需要知道重叠矩形的左下角和右上角

        for(int i = 0; i < n; i ++ ) {
            for(int j = 0; j < i; j ++ ) {
                int[] t1 = topRight[j], t2 = topRight[i];
                int[] b1 = bottomLeft[j], b2 = bottomLeft[i];
                int w = Math.min(t1[0], t2[0]) - Math.max(b1[0], b2[0]);
                int h = Math.min(t1[1], t2[1]) - Math.max(b1[1], b2[1]);
                ans = Math.max(ans, Math.min(w, h));
            }
        }

        return (long)ans * ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
